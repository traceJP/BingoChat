package src.main.java.com.tracejp.bingochart.client.controller;

import src.main.java.com.tracejp.bingochart.client.ClientRope;
import src.main.java.com.tracejp.bingochart.client.gui.ChatGUI;
import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.common.domain.ResponseMapping;

import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.util.Map;

/**
 * <p> 接收实时消息 <p/>
 *
 * 响应：Server.SendMessageController
 *
 * @author traceJP
 * @since 2023/5/12 15:00
 */
public class RespChatRealtimeMessageController implements IController {

    @Override
    public void handlerMessage(Map<String, Object> params, Connector connector) {
        String message = (String) params.get("message");
        HTMLDocument document = (HTMLDocument) ClientRope.chatGUI.chatLogTextArea.getDocument();
        try {
            document.insertAfterEnd(document.getCharacterElement(document.getLength()), message);
        } catch (BadLocationException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseMapping getResponseMapping() {
        return ResponseMapping.CHAT_REALTIME_MESSAGE;
    }

}
