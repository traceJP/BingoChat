package src.main.java.com.tracejp.bingochart.server;

import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.base.Connector;
import src.main.java.com.tracejp.bingochart.server.controller.ServiceContext;

import java.net.Socket;

/**
 * <p> 服务端连接处理器 <p/>
 *
 * @author traceJP
 * @since 2023/5/7 9:40
 */
public class ServerConnector extends Connector {

    private final ServiceContext serviceContext = ServiceContext.getInstance(ServiceContext.class);

    public ServerConnector(Socket socket) {
        super(socket);
        super.initReadThread();
    }

    @Override
    public void handlerMessage(Message message, Connector connector) {
        System.out.println("服务端收到消息：" + message);
        serviceContext.handleMessage(message, connector, message.getRequest());
    }

    @Override
    public void handlerExit() {
        ServerRope.onlineConnector.remove(this);
    }

}
