package com.yeqian.controller.webSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebSocketServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("web socket server started on port 8080");
            while (true) {
                //循环接收用户的连接信息
                Socket socket = serverSocket.accept();
                System.out.println("web socket server accept new connection");
                //创建一个新的线程对象并开启
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
