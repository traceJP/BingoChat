package src.main.java.com.tracejp.bingochart.client;

import src.main.java.com.tracejp.bingochart.client.gui.ChatGUI;
import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.common.utils.MD5Utils;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/7 21:24
 */
public class ClientRope {

    public static Connector serverConnector;

    /**
     * 当前客户端 username
     */
    public static String username = "traceJP";  // TODO 暂时写死

    /**
     * uuid
     */
    public static String getUserUUID() {
        return MD5Utils.parseMd5(username);
    }

    public static ChatGUI chatGUI;

}
