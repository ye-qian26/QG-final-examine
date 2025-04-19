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

    /**
     * 添加板块
     * @param req
     * @param resp
     * @throws Exception
     */
    public void updatePlateNotice(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _plateId = req.getParameter("plateId");
        String _notice = req.getParameter("notice");
        Integer plateId = JSON.parseObject(_plateId, Integer.class);
        String notice = new String(_notice.getBytes("iso8859-1"), StandardCharsets.UTF_8);
        //3.执行service方法
        plateService.updatePlateNotice(plateId, notice);
        //4.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 根据 板块id 查询 板块
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectPlateById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _plateId = req.getParameter("plateId");
        Integer plateId = JSON.parseObject(_plateId, Integer.class);
        //3.执行service方法
        Plate plate = plateService.selectById(plateId);
        //4.响应数据
        if (plate != null) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(plate));
        } else {
            resp.getWriter().write("fail");
        }
    }

    /**
     * 查询所有板块
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectAllPlate(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.执行service方法
        List<Plate> plates = plateService.selectAllPlate();
        //2.响应数据
        if (plates != null && !plates.isEmpty()) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(plates));
        } else {
            resp.getWriter().write("fail");
        }
    }


    /**
     * 根据 板块名 模糊查询 板块
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectPlateByName(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        //2.接收数据
        String _plateName = req.getParameter("plateName");
        String _select = req.getParameter("select");
        String select = new String(_select.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        //3.判断用户输入的字段是否为空
        List<Plate> plates = null;
        if (_plateName != null && !_plateName.isEmpty()) {
            // plateName 不为空
            String plateName = new String(_plateName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            //用户输入的板块不为空
            //4.处理字段
            plateName = "%" + plateName.trim() + "%";
            //判断用户的选择条件
            //5.执行service方法
            if (select.isEmpty()) {
                //用户未选择条件
                plates = plateService.selectPlateByName(plateName);
            } else if ("最多浏览".equals(select)) {
                //用户选择查询最多浏览板块
                plates = plateService.selectPlateByNameWithPageView(plateName);
            } else if("最多点赞".equals(select)) {
                //用户选择查询最多点赞板块
                plates = plateService.selectPlateByNameWithLikes(plateName);
            }
            //6.响应数据
            if (plates != null && !plates.isEmpty()) {
                resp.getWriter().write(JSON.toJSONString(plates));
            } else {
                resp.getWriter().write("fail");
            }
        } else {
            // plateName 为空
            if (select.isEmpty()) {
                //用户未选择条件
                plates = plateService.selectAllPlate();
            } else if ("最多浏览".equals(select)) {
                //用户选择查询最多浏览板块
                plates = plateService.selectPlateWithPageView();
            } else if("最多点赞".equals(select)) {
                //用户选择查询最多点赞板块
                plates = plateService.selectPlateWithLikes();
            }

            if (plates != null && !plates.isEmpty()) {
                resp.getWriter().write(JSON.toJSONString(plates));
            } else {
                resp.getWriter().write("fail");
            }
        }
    }

    /**
     * 增加板块点赞量
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addPlateLikesById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("UTF-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        Integer plateId = JSON.parseObject(jsonString, Integer.class);
        //3.执行service方法
        plateService.addPlateLikes(plateId);
        //4.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 减少帖子点赞量
     * @param req
     * @param resp
     * @throws Exception
     */
    public void reducePlateLikesById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("UTF-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        Integer plateId = JSON.parseObject(jsonString, Integer.class);
        //3.执行service方法
        plateService.reducePlateLikes(plateId);
        //4.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 增加板块浏览量
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addPlatePageView(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("UTF-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        Integer plateId = JSON.parseObject(jsonString, Integer.class);
        //3.执行service方法
        plateService.addPlatePageView(plateId);
        //4.响应数据
        resp.getWriter().write("success");
    }
}
