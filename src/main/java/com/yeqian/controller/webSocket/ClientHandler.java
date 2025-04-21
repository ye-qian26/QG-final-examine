package com.yeqian.controller.webSocket;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientHandler extends Thread {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader reader;
    private String userInfo;
    private static final Map<String, PrintWriter> clientOutPutStreams = new ConcurrentHashMap<>();

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //得到发送者的打印流
            out = new PrintWriter(socket.getOutputStream());
            //得到缓冲输入流
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //读取信息
            String message;
            while((message = reader.readLine()) != null) {
                //处理信息
                handleMessage(message);
            }
        } catch (IOException e) {
            System.err.println("Error handling client connection: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {

            try {
                if (reader != null) {
                    reader.close();
                }
                if (out != null) {
                    out.close();
                }
                socket.close();
                if (userInfo != null) {
                    clientOutPutStreams.remove(userInfo);
                }
            } catch (IOException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    private void handleMessage(String message) {
        try {
            //使用json解析message
            JSONObject jsonMessage = new JSONObject(message);
            //得到具体信息
            String sender = jsonMessage.getString("sender");
            String content = jsonMessage.getString("content");
            String receiver = jsonMessage.getString("receiver");

            if (userInfo == null) {
                userInfo = sender;
                clientOutPutStreams.put(userInfo, out);
            }

            PrintWriter receiverWriter = clientOutPutStreams.get(receiver);
            if (receiverWriter != null) {
                //如果接收者有登录
                //发送信息
                receiverWriter.println(content);
                receiverWriter.flush();
            } else {
                out.println("Receiver " + receiver + " is not logged in.");
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
