package src.main.java.com.tracejp.bingochart.server;

import src.main.java.com.tracejp.bingochart.common.domain.base.Connector;

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
    public static CopyOnWriteArrayList<Connector> onlineConnector = new CopyOnWriteArrayList<>();

}
