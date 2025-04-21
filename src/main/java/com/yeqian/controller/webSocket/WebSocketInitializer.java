package com.yeqian.controller.webSocket;

import org.glassfish.tyrus.server.Server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.websocket.DeploymentException;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class WebSocketInitializer implements ServletContextListener {
    private Server server;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Map<String, Object> properties = new HashMap<>();
        server = new Server("localhost", 8081, "/ws", properties, ChatEndpoint.class);
        try {
            server.start();
            // 添加关闭钩子
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    server.stop();
                    System.out.println("WebSocket 服务器已停止");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }));
            System.out.println("WebSocket 服务器已启动，访问 ws://localhost:8081/ws/chat");
        } catch (DeploymentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (server != null) {
            server.stop();
        }
    }
}