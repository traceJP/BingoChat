package src.main.java.com.tracejp.bingochart.server.controller;

import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.RequestMapping;
import src.main.java.com.tracejp.bingochart.server.ServerRope;
import src.main.java.com.tracejp.bingochart.server.entity.UserEntity;

import java.util.Map;

/**
 * <p> 上线 <p/>
 *
 * 参数要求：string uuid, string nick_name
 *
 * @author traceJP
 * @since 2023/5/12 8:24
 */
public class OnlineController implements IController {

    @Override
    public Message handlerMessage(Map<String, Object> params, Connector connector) {
        String uuid = (String) params.get("uuid");
        String nickName = (String) params.get("nick_name");
        UserEntity user = new UserEntity(uuid, nickName, connector);
        ServerRope.onlineUser.put(user.getUuid(), user);
        System.out.println("用户上线：" + user.getUuid() + " " + user.getNickName());
        return null;
    }

    @Override
    public RequestMapping getRequestMapping() {
        return RequestMapping.ONLINE;
    }

}
