package src.main.java.com.tracejp.bingochart.server;

import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.server.entity.ChatMessageEntity;
import src.main.java.com.tracejp.bingochart.server.entity.FontConfigEntity;
import src.main.java.com.tracejp.bingochart.server.entity.UserEntity;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/8 8:17
 */
public class ServerRope {

    /**
     * 在线连接
     */
    public static final CopyOnWriteArrayList<Connector> onlineConnector;

    /**
     * 在线用户  key: uuid，value: userEntity
     */
    public static final ConcurrentMap<String, UserEntity> onlineUser;

    /**
     * 字体配置  key: uuid，value: fontConfigDTO
     */
    public static final ConcurrentMap<String, FontConfigEntity> fontConfig;

    /**
     * 聊天记录
     */
    public static final ConcurrentLinkedQueue<ChatMessageEntity> chatLog;

    static {
        onlineConnector = new CopyOnWriteArrayList<>();
        onlineUser = new ConcurrentHashMap<>();
        fontConfig = new ConcurrentHashMap<>();
        chatLog = new ConcurrentLinkedQueue<>();
    }

}
