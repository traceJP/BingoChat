package src.main.java.com.tracejp.bingochart.client.controller;

import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.common.domain.ResponseMapping;

import java.util.List;
import java.util.Map;

/**
 * <p>  <p/>
 *
 * 响应类：server.QueryChatLogController
 *
 * @author traceJP
 * @since 2023/5/12 15:07
 */
public class RespChatLogController implements IController {

    @Override
    public void handlerMessage(Map<String, Object> params, Connector connector) {
        //noinspection unchecked
        List<String> chatLog = (List<String>) params.get("chatLog");

        chatLog.forEach(System.out::println);

    }

    @Override
    public ResponseMapping getResponseMapping() {
        return ResponseMapping.CHAT_LOG;
    }

}
