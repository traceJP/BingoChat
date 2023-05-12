package src.main.java.com.tracejp.bingochart.server.controller;

import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.RequestMapping;
import src.main.java.com.tracejp.bingochart.common.domain.ResponseMapping;
import src.main.java.com.tracejp.bingochart.common.utils.UUIDUtil;
import src.main.java.com.tracejp.bingochart.server.ServerRope;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/12 14:50
 */
public class QueryRoomInfo implements IController {

    @Override
    public Message handlerMessage(Map<String, Object> params, Connector connector) {
        Map<String, Object> roomInfo = new HashMap<>();
        roomInfo.put("online_number", ServerRope.onlineUser.size());
        return new Message(UUIDUtil.getUUID(), ResponseMapping.ROOM_INFO, roomInfo);
    }

    @Override
    public RequestMapping getRequestMapping() {
        return RequestMapping.QUERY_ROOM_INFO;
    }

}
