package src.main.java.com.tracejp.bingochart.client.controller;

import src.main.java.com.tracejp.bingochart.client.ClientRope;
import src.main.java.com.tracejp.bingochart.client.gui.ChatGUI;
import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.common.domain.ResponseMapping;

import java.util.Map;

/**
 * <p>  <p/>
 * <p>
 * 响应类：server.QueryFontConfigController
 *
 * @author traceJP
 * @since 2023/5/12 15:05
 */
public class RespFontConfigController implements IController {

    @Override
    public void handlerMessage(Map<String, Object> params, Connector connector) {
        Integer fontSize = (Integer) params.get("font_size");
        Integer fontStyle = (Integer) params.get("font_style");
        Integer fontColor = (Integer) params.get("font_color");
        ChatGUI chatGUI = ClientRope.chatGUI;
        if (fontSize != null) {
            chatGUI.fontSizeComboBox.setSelectedIndex(fontSize);
            chatGUI.fontSizeComboBox.repaint();
        }
        if (fontStyle != null) {
            chatGUI.fontStyleComboBox.setSelectedIndex(fontStyle);
            chatGUI.fontStyleComboBox.repaint();
        }
        if (fontColor != null) {
            chatGUI.fontColorComboBox.setSelectedIndex(fontColor);
            chatGUI.fontColorComboBox.repaint();
        }
    }

    @Override
    public ResponseMapping getResponseMapping() {
        return ResponseMapping.FONT_CONFIG;
    }

}
