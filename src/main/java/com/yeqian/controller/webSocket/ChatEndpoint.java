package com.yeqian.controller.webSocket;

import org.json.JSONException;
import org.json.JSONObject;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ServerEndpoint("/chat")
public class ChatEndpoint {
    private static final Map<String, Session> clients = new HashMap<>();
    private static final Map<Session, String> sessionToUsername = new HashMap<>();

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("新连接: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {

        try {
            //使用json解析message
            JSONObject jsonMessage = new JSONObject(message);
            //得到发送者和接收者
            String sender = jsonMessage.getString("sender");
            String receiver = jsonMessage.getString("receiver");

            //处理用户连接与用户名存储逻辑（用户登录时）
            if (!sessionToUsername.containsKey(session)) {
                sessionToUsername.put(session, sender);
                clients.put(sender, session);
                System.out.println("用户 " + sender + " 已连接");
                return;
            }

            //获取接收者的session准备发送消息
            Session recipientSession = clients.get(receiver);
            if (recipientSession != null && recipientSession.isOpen()) {
                recipientSession.getBasicRemote().sendText(message);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @OnClose
    public void onClose(Session session) {
        String username = sessionToUsername.get(session);
        if (username != null) {
            System.out.println("用户 " + username + " 断开连接: " + session.getId());
            clients.remove(username);
            sessionToUsername.remove(session);
        } else {
            System.out.println("连接关闭: " + session.getId());
        }
    }

    @OnError
    public void onError(Throwable error) {
        error.printStackTrace();
    }
}
