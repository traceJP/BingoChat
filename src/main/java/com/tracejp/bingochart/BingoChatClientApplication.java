package src.main.java.com.tracejp.bingochart;

import src.main.java.com.tracejp.bingochart.client.ClientConnector;
import src.main.java.com.tracejp.bingochart.client.ClientGUI;
import src.main.java.com.tracejp.bingochart.client.ClientRope;
import src.main.java.com.tracejp.bingochart.common.constant.AddressConstant;

/**
 * <p> 客户端启动类 <p/>
 *
 * @author traceJP
 * @since 2023/5/6 9:15
 */
public class BingoChatClientApplication {

    public static void main(String[] args) throws InterruptedException {
        // 启动 GUI
        new Thread(new ClientGUI()).start();
        // 与服务器建立连接
        ClientRope.serverConnector = new ClientConnector(
                AddressConstant.SERVER_ADDRESS_DEFAULT,
                AddressConstant.SERVER_PORT_DEFAULT
        );
    }

}
