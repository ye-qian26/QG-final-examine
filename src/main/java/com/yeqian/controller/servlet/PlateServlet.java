package com.yeqian.controller.servlet;

import com.alibaba.fastjson.JSON;
import com.yeqian.pojo.Plate;
import com.yeqian.service.PlateService;
import com.yeqian.service.impl.PlateServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/plateServlet/*")
public class PlateServlet extends BaseServlet {
    PlateService plateService = new PlateServiceImpl();

    /**
     * 添加板块
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addPlate(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.接收数据
        String _userId = req.getParameter("userId");
        String _name = req.getParameter("name");
        //2.转换数据
        Integer userId = JSON.parseObject(_userId, Integer.class);
        String name = new String(_name.getBytes("iso8859-1"), StandardCharsets.UTF_8);
        //3.执行service方法
        plateService.addPlate(userId, name);
        //4.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 添加板块
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectPlateByUserId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.接收数据
        String _userId = req.getParameter("userId");
        //2.转换数据
        Integer userId = JSON.parseObject(_userId, Integer.class);
        //3.执行service方法
        List<Plate> plates = plateService.selectByUserId(userId);
        //4.响应数据
        if (plates != null && !plates.isEmpty()) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(plates));
        } else {
            resp.getWriter().write("fail");
        }
    }
}
