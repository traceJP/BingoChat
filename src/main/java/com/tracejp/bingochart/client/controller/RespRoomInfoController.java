package src.main.java.com.tracejp.bingochart.client.controller;

import src.main.java.com.tracejp.bingochart.client.gui.ChatGUI;
import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.common.domain.ResponseMapping;

import java.util.Map;

/**
 * <p>  <p/>
 *
 * 响应类：server.QueryRoomInfoController
 *
 * @author traceJP
 * @since 2023/5/12 15:14
 */
public class RespRoomInfoController implements IController {

    private final ChatGUI chatGUI = ChatGUI.getInstance(ChatGUI.class);


    @Override
    public void handlerMessage(Map<String, Object> params, Connector connector) {
        Integer onlineNumber = (Integer) params.get("online_number");
        chatGUI.onlineUserNumberLabel.setText(onlineNumber.toString());
    }

    @Override
    public ResponseMapping getResponseMapping() {
        return ResponseMapping.ROOM_INFO;
    }

}
