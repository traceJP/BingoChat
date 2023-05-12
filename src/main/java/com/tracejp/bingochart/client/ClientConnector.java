package src.main.java.com.tracejp.bingochart.client;

import src.main.java.com.tracejp.bingochart.client.controller.ServiceContext;
import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.Connector;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/7 9:53
 */
public class ClientConnector extends Connector {

    private final ServiceContext serviceContext = ServiceContext.getInstance(ServiceContext.class);

    public ClientConnector(String host, int port) {
        super(host, port);
        super.initReadThread();
    }

    @Override
    public void handlerMessage(Message message, Connector connector) {
        System.out.println("客户端接收到消息：" + message);
        serviceContext.handleMessage(message, connector, message.getResponse());
    }

    @Override
    public void handlerExit() {
        System.out.println("客户端退出");
    }

}
