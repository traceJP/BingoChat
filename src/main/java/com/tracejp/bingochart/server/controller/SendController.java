package src.main.java.com.tracejp.bingochart.server.controller;

import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.RequestMapping;

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
    public RequestMapping getRequestMapping() {
        return RequestMapping.SEND;
    }

}
