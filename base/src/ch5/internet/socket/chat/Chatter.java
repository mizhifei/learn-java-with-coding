package ch5.internet.socket.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

import static ch5.internet.socket.chat.ChatServer.BYE;
import static ch5.internet.socket.chat.ChatServer.SERVER_CHARSET;

public class Chatter {

    private String from;
    private String greetings;
    private Socket socket;

    private static final Logger logger = Logger.getLogger(Chatter.class.getName());

    public Chatter(String from, String greetings, Socket socket) {
        this.from = from;
        this.greetings = greetings;
        this.socket = socket;
    }

    public void chatting() throws IOException {
        Scanner scanner = new Scanner(System.in);

        try (
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), SERVER_CHARSET));
                PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), SERVER_CHARSET));
        ) {
            logger.info("Socket连接成功！建立输入输出");
            if (greetings != null) {
                printWriter.println("你好，" + from + "。" + greetings);
                printWriter.flush();
            }
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine.trim().equalsIgnoreCase(BYE)) {
                    logger.info("对方要求断开连接");
                    printWriter.println(BYE);
                    printWriter.flush();
                    break;
                } else {
                    logger.info(() -> "来自\"" + from + "\"的消息：" + readLine);
                }
                String nextLine = scanner.nextLine();
                printWriter.println(nextLine);
                printWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("聊天结束。");

    }


}
