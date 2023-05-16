package src.main.java.com.tracejp.bingochart.client.controller;

import src.main.java.com.tracejp.bingochart.client.ClientRope;
import src.main.java.com.tracejp.bingochart.client.gui.ChatGUI;
import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.common.domain.ResponseMapping;

import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>  <p/>
 * <p>
 * 响应类：server.QueryChatLogController
 *
 * @author traceJP
 * @since 2023/5/12 15:07
 */
public class RespChatLogController implements IController {

    @Override
    public void handlerMessage(Map<String, Object> params, Connector connector) {
        //noinspection unchecked
        List<String> chatLogs = (List<String>) params.get("chatLog");
        for (String chatLine : chatLogs) {
            HTMLDocument document = (HTMLDocument) ClientRope.chatGUI.chatLogTextArea.getDocument();
            try {
                document.insertAfterEnd(document.getCharacterElement(document.getLength()), chatLine);
            } catch (BadLocationException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public ResponseMapping getResponseMapping() {
        return ResponseMapping.CHAT_LOG;
    }

}
