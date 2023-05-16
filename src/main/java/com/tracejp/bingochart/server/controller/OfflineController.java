package src.main.java.com.tracejp.bingochart.server.controller;

import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.RequestMapping;
import src.main.java.com.tracejp.bingochart.server.ServerRope;
import src.main.java.com.tracejp.bingochart.server.entity.UserEntity;

import java.util.Map;

/**
 * <p> 下线 <p/>
 *
 * 参数要求：string uuid
 *
 * @author traceJP
 * @since 2023/5/12 8:29
 */
public class OfflineController implements IController {

    @Override
    public Message handlerMessage(Map<String, Object> params, Connector connector) {
        String uuid = (String) params.get("uuid");
        System.out.println(ServerRope.onlineUser.size());
        UserEntity user = ServerRope.onlineUser.remove(uuid);
        System.out.println(ServerRope.onlineUser.size());
        connector.closeSocket();
        System.out.println("用户下线：" + user.getUuid() + " " + user.getUsername());
        return null;
    }

    @Override
    public RequestMapping getRequestMapping() {
        return RequestMapping.OFFLINE;
    }

}
