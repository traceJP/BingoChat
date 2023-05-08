package src.main.java.com.tracejp.bingochart;

import src.main.java.com.tracejp.bingochart.server.SocketListener;

/**
 * <p> 服务器启动类 <p/>
 *
 * @author traceJP
 * @since 2023/5/6 9:14
 */
public class BingoChatServerApplication {

    public static void main(String[] args) {
        new Thread(new SocketListener()).start();
    }

}
