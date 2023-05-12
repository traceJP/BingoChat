package src.main.java.com.tracejp.bingochart.server.controller;

import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.RequestMapping;
import src.main.java.com.tracejp.bingochart.common.domain.ResponseMapping;
import src.main.java.com.tracejp.bingochart.common.utils.UUIDUtils;
import src.main.java.com.tracejp.bingochart.server.ServerRope;
import src.main.java.com.tracejp.bingochart.server.entity.ChatMessageEntity;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p> 查询聊天记录 <p/>
 *
 * 参数要求：Integer number
 *
 * @author traceJP
 * @since 2023/5/12 9:31
 */
public class QueryChatLogController implements IController {

    @Override
    public Message handlerMessage(Map<String, Object> params, Connector connector) {
        Integer number = (Integer) params.get("number");
        List<String> messages = ServerRope.chatLog.stream()
                .map(ChatMessageEntity::getMessage)
                .collect(Collectors.toList());
        if (messages.size() > number) {
            messages = messages.subList(0, number);
        }
        return new Message(UUIDUtils.getUUID(), ResponseMapping.CHAT_LOG, Collections.singletonMap("chatLog", messages));
    }

    @Override
    public RequestMapping getRequestMapping() {
        return RequestMapping.QUERY_CHAT_LOG;
    }

}
