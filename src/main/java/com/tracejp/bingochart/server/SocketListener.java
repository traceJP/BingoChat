package src.main.java.com.tracejp.bingochart.server;

import src.main.java.com.tracejp.bingochart.common.constant.AddressConstant;
import src.main.java.com.tracejp.bingochart.common.domain.Connector;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/6 16:20
 */
public class SocketListener implements Runnable {

    public ServerSocket serverSocket;

    public volatile Boolean isRunning;


    @Override
    public void run() {
        // 开启服务器
        try {
            serverSocket = new ServerSocket(AddressConstant.SERVER_PORT_DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException("服务器启动失败 原因可能是：端口{" + AddressConstant.SERVER_PORT_DEFAULT + "}被占用");
        }
        isRunning = true;
        System.out.println("Bingo Server 启动成功");

        // 等待客户端连接
        acceptClientSocket();
    }

    private void acceptClientSocket() {
        Socket socket;
        while (isRunning) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Connector connector = new ServerConnector(socket);
            ServerRope.onlineConnector.add(connector);
            System.out.println("客户端连接成功 => {" + socket.getInetAddress() + ":" + socket.getPort() + "}");
        }
    }

}
