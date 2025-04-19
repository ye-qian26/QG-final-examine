package com.yeqian.controller.servlet;

import com.alibaba.fastjson.JSON;
import com.yeqian.pojo.HistoricalRecord;
import com.yeqian.pojo.InterestPlateList;
import com.yeqian.pojo.Post;
import com.yeqian.service.HistoricalRecordService;
import com.yeqian.service.InterestPlateListService;
import com.yeqian.service.impl.HistoricalRecordServiceImpl;
import com.yeqian.service.impl.InterestPlateListServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/historicalRecordServlet/*")
public class HistoricalRecordServlet extends BaseServlet {
    HistoricalRecordService historicalRecordService = new HistoricalRecordServiceImpl();

    /**
     * 增加 历史记录
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addHistoricalRecord(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _hr = req.getReader().readLine();
        //3.转换数据
        HistoricalRecord hr = JSON.parseObject(_hr, HistoricalRecord.class);
        //4.先删除历史记录
        historicalRecordService.deleteHistoricalRecord(hr);
        //5.再添加历史记录
        historicalRecordService.addHistoricalRecord(hr);
        //6.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 删除 历史记录
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deleteHistoricalRecord(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _hr = req.getReader().readLine();
        //3.转换数据
        HistoricalRecord hr = JSON.parseObject(_hr, HistoricalRecord.class);
        //4.执行service方法
        historicalRecordService.deleteHistoricalRecord(hr);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 查询 用户 的 历史记录
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectHistoricalRecordByUserId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _userId = req.getParameter("userId");
        //3.转换数据
        Integer userId = JSON.parseObject(_userId, Integer.class);
        //4.执行service方法
        List<Post> posts = historicalRecordService.selectHistoricalRecordsByUserId(userId);
        //5.响应数据
        if (posts != null && !posts.isEmpty()) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(posts));
        } else {
            resp.getWriter().write("fail");
        }
    }

}
