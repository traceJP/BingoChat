package src.main.java.com.tracejp.bingochart.server.controller;

import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.RequestMapping;
import src.main.java.com.tracejp.bingochart.common.domain.ResponseMapping;
import src.main.java.com.tracejp.bingochart.common.utils.UUIDUtil;
import src.main.java.com.tracejp.bingochart.server.ServerRope;
import src.main.java.com.tracejp.bingochart.server.entity.ChatMessageEntity;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * <p> 发送消息到聊天室 <p/>
 * <p>
 * 参数要求：String uuid, String message
 *
 * @author traceJP
 * @since 2023/5/7 20:50
 */
public class SendMessageController implements IController {

    private static final int MAX_CHAT_LOG = 150;

    @Override
    public Message handlerMessage(Map<String, Object> params, Connector connector) {
        String uuid = (String) params.get("uuid");
        String message = (String) params.get("message");

        // 转发给所有在线连接
        ServerRope.onlineConnector.forEach(item -> {
            if (item != null && item != connector) {
                Message redirectMessage = new Message(
                        UUIDUtil.getUUID(),
                        ResponseMapping.CHAT_REALTIME_MESSAGE,
                        Collections.singletonMap("message", message)
                );
                item.sendMessage(redirectMessage);
            }
        });

        // 记录日志
        ChatMessageEntity chatMessageEntity = new ChatMessageEntity(uuid, message, System.currentTimeMillis());
        ConcurrentLinkedQueue<ChatMessageEntity> chatLog = ServerRope.chatLog;
        if (chatLog.size() > MAX_CHAT_LOG) {
            chatLog.poll();
        }
        chatLog.offer(chatMessageEntity);

        return null;
    }

    @Override
    public RequestMapping getRequestMapping() {
        return RequestMapping.SEND_MESSAGE;
    }

}
