package ch5.internet.socket.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class ChatServer {

    public static final String SERVER_IP = "47.99.193.84";
    public static final int SERVER_PORT = 54321;
    public static final String BYE = "bye";
    public static final Charset SERVER_CHARSET = StandardCharsets.UTF_8;
    private static final Logger logger = Logger.getLogger(ChatServer.class.getName());


    public static void main(String[] args) throws IOException {
        communicateWithClient();
    }

    private static void communicateWithClient() throws IOException {
        logger.info("Server端启动在端口" + SERVER_PORT + "监听……");

        try (
                ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
                Socket socket = serverSocket.accept()
        ) {
            Chatter chatter = new Chatter("服务端", "你已经成功连接到服务器了，开始聊天吧！", socket);
            chatter.chatting();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("程序退出");


    }
}
