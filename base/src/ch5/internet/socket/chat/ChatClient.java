package ch5.internet.socket.chat;

import java.io.IOException;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args) throws IOException {
        communicateWithServer();
    }

    private static void communicateWithServer() throws IOException {
        try (
                Socket socket = new Socket(ChatServer.SERVER_IP, ChatServer.SERVER_PORT);
        ) {
            Chatter chatter = new Chatter("客户端", null, socket);
            chatter.chatting();
        }

    }
}
