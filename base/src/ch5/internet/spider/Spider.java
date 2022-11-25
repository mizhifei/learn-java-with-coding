package ch5.internet.spider;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Spider {
    public static void main(String[] args) throws IOException {
        System.out.println("解析域名……");
        InetAddress inetAddress = InetAddress.getByName("www.hao123.com");


        System.out.println("网站地址为：" + inetAddress);
        System.out.println("尝试连接到主机……");
        try (Socket socket = new Socket();) {

            InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress, 80);
            socket.connect(inetSocketAddress, 1000);
            System.out.println("已经连接到主机，开始模拟发送http请求……");

            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

            // 这是HTTP协议标准的请求头
            String s = "GET /index.html HTTP/1.1\r\n"
                    + "Host: www.hao123.com\r\n"
                    + "Connection: Keep-Alive\r\n"
                    + "\r\n";
            printWriter.write(s);
            printWriter.flush();

            System.out.println("请求已经发送，开始读取主页内容……");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

            bufferedReader.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
