package com.yeqian.controller.servlet;

import com.alibaba.fastjson.JSON;
import com.yeqian.pojo.AccountBan;
import com.yeqian.pojo.ChatRecord;
import com.yeqian.service.AccountBanService;
import com.yeqian.service.ChatRecordService;
import com.yeqian.service.impl.AccountBanServiceImpl;
import com.yeqian.service.impl.ChatRecordServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/chatRecordServlet/*")
public class ChatRecordServlet extends BaseServlet {
    ChatRecordService chatRecordService = new ChatRecordServiceImpl();

    /**
     * 插叙 两个用户 之间的 聊天记录
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectChatRecordBySenderIdAndReceiverId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _senderId = req.getParameter("senderId");
        String _receiverId = req.getParameter("receiverId");
        //3.转换数据
        Integer senderId = JSON.parseObject(_senderId, Integer.class);
        Integer receiverId = JSON.parseObject(_receiverId, Integer.class);
        //4.执行service方法
        List<ChatRecord> chatRecords = chatRecordService.selectBySenderIdAndReceiverId(senderId, receiverId);
        //5.响应数据
        if (chatRecords != null && !chatRecords.isEmpty()) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(chatRecords));
        } else {
            resp.getWriter().write("fail");
        }
    }

    /**
     * 插叙 两个用户 之间的 聊天记录
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addChatRecord(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        ChatRecord chatRecord = JSON.parseObject(jsonString, ChatRecord.class);
        //4.获取当前时间
        LocalDateTime now = LocalDateTime.now();
        //定义格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //转换
        String formatTime = now.format(formatter);
        chatRecord.setSendTime(formatTime);
        //5.执行service方法
        chatRecordService.addChatRecord(chatRecord);
        //6.响应数据
        resp.getWriter().write("success");
    }




}
