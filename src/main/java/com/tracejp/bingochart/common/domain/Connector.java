package src.main.java.com.tracejp.bingochart.common.domain;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.CompletableFuture;

/**
 * <p> 连接者 p/>
 *
 * @author traceJP
 * @since 2023/5/6 17:06
 */
public abstract class Connector {

    protected Socket socket = null;

    public Connector() {
    }

    public Connector(Socket socket) {
        this.socket = socket;
    }

    public Connector(String host, int port) {
        try {
            this.socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void handlerMessage(Message message, Connector connector);

    public abstract void handlerExit();

    public void initReadThread() {
        if (socket == null) {
            throw new RuntimeException("Socket对象为空");
        }
        CompletableFuture.runAsync(() -> {
            try {
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream;
                while (!socket.isClosed()) {
                    // 优化 需要改成心跳连接机制
                    if (inputStream.available() > 0) {
                        objectInputStream = new ObjectInputStream(inputStream);
                        Message message = (Message) objectInputStream.readObject();
                        handlerMessage(message, this);
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                closeSocket("异常关闭，原因：" + e.getMessage());
            }
            closeSocket();
        });
    }

    public void closeSocket() {
        closeSocket("正常关闭");
    }

    public void closeSocket(String message) {
        handlerExit();
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Socket连接关闭：" + message);
        }
    }

    public void sendMessage(Message message) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(message);
            // 防止消息重叠
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
            closeSocket("异常关闭，原因：" + e.getMessage());
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

}
