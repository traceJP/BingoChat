package src.main.java.com.tracejp.bingochart;

import src.main.java.com.tracejp.bingochart.client.ClientConnector;
import src.main.java.com.tracejp.bingochart.client.ClientGUI;
import src.main.java.com.tracejp.bingochart.client.ClientRope;
import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.RequestMapping;
import src.main.java.com.tracejp.bingochart.common.domain.base.Connector;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static src.main.java.com.tracejp.bingochart.common.constant.AddressConstant.SERVER_ADDRESS_DEFAULT;
import static src.main.java.com.tracejp.bingochart.common.constant.AddressConstant.SERVER_PORT_DEFAULT;

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
        // ClientRope.server = new ClientConnector(SERVER_ADDRESS_DEFAULT, SERVER_PORT_DEFAULT);
    }

}
