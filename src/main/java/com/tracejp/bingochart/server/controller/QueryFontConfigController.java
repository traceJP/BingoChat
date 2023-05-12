package src.main.java.com.tracejp.bingochart.server.controller;

import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.RequestMapping;
import src.main.java.com.tracejp.bingochart.common.domain.ResponseMapping;
import src.main.java.com.tracejp.bingochart.common.utils.UUIDUtils;
import src.main.java.com.tracejp.bingochart.server.ServerRope;
import src.main.java.com.tracejp.bingochart.server.entity.FontConfigEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/12 9:06
 */
public class QueryFontConfigController implements IController {

    @Override
    public Message handlerMessage(Map<String, Object> params, Connector connector) {
        String uuid = (String) params.get("uuid");
        FontConfigEntity config = ServerRope.fontConfig.get(uuid);
        if (config == null) {
            return null;
        }

        // 响应消息
        Map<String, Object> responseParams = new HashMap<>(3);
        responseParams.put("font_size", config.getSize());
        responseParams.put("font_style", config.getStyle());
        responseParams.put("font_color", config.getColor());
        return new Message(UUIDUtils.getUUID(), ResponseMapping.FONT_CONFIG, responseParams);
    }

    @Override
    public RequestMapping getRequestMapping() {
        return RequestMapping.QUERY_FONT_CONFIG;
    }

}
