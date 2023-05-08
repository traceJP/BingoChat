package src.main.java.com.tracejp.bingochart.client.controller;

import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.ResponseMapping;

import java.util.Map;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/7 20:50
 */
public class SendController implements IController {

    @Override
    public Message handlerMessage(Map<String, Object> params) {

        System.out.println("准备处理发送过来的消息，sendController");
        String name = (String) params.get("name");
        System.out.println("name为：" + name);

        return null;
    }

    @Override
    public ResponseMapping getResponseMapping() {
        return ResponseMapping.SEND;
    }

}
