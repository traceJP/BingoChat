package src.main.java.com.tracejp.bingochart.client.controller;

import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.common.domain.ResponseMapping;

import java.awt.*;
import java.util.Map;

/**
 * <p>  <p/>
 *
 * 响应类：server.QueryFontConfigController
 *
 * @author traceJP
 * @since 2023/5/12 15:05
 */
public class RespFontConfigController implements IController {

    @Override
    public void handlerMessage(Map<String, Object> params, Connector connector) {
        Integer fontSize = (Integer) params.get("font_size");
        String fontStyle = (String) params.get("font_style");
        Color fontColor = (Color) params.get("font_color");
        System.out.println("字体配置：" + fontSize + " " + fontStyle + " " + fontColor);
    }

    @Override
    public ResponseMapping getResponseMapping() {
        return ResponseMapping.FONT_CONFIG;
    }

}
