package src.main.java.com.tracejp.bingochart.server.controller;

import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.RequestMapping;
import src.main.java.com.tracejp.bingochart.server.ServerRope;
import src.main.java.com.tracejp.bingochart.server.entity.FontConfigEntity;

import java.util.Map;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/12 8:50
 */
public class SaveFontConfigController implements IController {

    @Override
    public Message handlerMessage(Map<String, Object> params, Connector connector) {
        String uuid = (String) params.get("uuid");
        Integer fontSize = (Integer) params.get("font_size");
        Integer fontStyle = (Integer) params.get("font_style");
        Integer fontColor = (Integer) params.get("font_color");
        FontConfigEntity fontConfigEntity = new FontConfigEntity(fontSize, fontStyle, fontColor);
        ServerRope.fontConfig.put(uuid, fontConfigEntity);
        return null;
    }

    @Override
    public RequestMapping getRequestMapping() {
        return RequestMapping.SAVE_FONT_CONFIG;
    }

}
