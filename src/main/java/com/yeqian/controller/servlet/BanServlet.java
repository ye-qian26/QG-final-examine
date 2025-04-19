package com.yeqian.controller.servlet;

import com.alibaba.fastjson.JSON;
import com.yeqian.pojo.Ban;
import com.yeqian.pojo.ReportedPost;
import com.yeqian.service.BanService;
import com.yeqian.service.ReportedPostService;
import com.yeqian.service.impl.BanServiceImpl;
import com.yeqian.service.impl.ReportedPostServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/banServlet/*")
public class BanServlet extends BaseServlet {
    BanService banService = new BanServiceImpl();

    /**
     * 增加封禁用户
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addBan(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        Ban ban = JSON.parseObject(jsonString, Ban.class);
        //4.执行service方法
        banService.add(ban);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 根据用户id和板块id查询封禁用户
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectByUserIdAndPlateId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _userId = req.getParameter("banUserId");
        String _plateId = req.getParameter("plateId");
        //3.转换数据
        Integer banUserId = JSON.parseObject(_userId, Integer.class);
        Integer plateId = JSON.parseObject(_plateId, Integer.class);
        //4.执行service方法
        Ban ban = banService.selectByUserIdAndPlateId(banUserId, plateId);
        //5.响应数据
        if (ban != null) {
            //有数据
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(ban));
        } else {
            resp.getWriter().write("fail");
        }
    }


    /**
     * 删除封禁用户
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deleteBan(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        Ban ban = JSON.parseObject(jsonString, Ban.class);
        //4.执行service方法
        banService.deleteBan(ban);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 根据 用户id 查询 封禁表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectBanByUserId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _userId = req.getParameter("userId");
        //3.转换数据
        Integer userId = JSON.parseObject(_userId, Integer.class);
        //4.执行service方法
        List<Ban> bans = banService.selectByUserId(userId);
        //5.响应数据
        if (bans != null && !bans.isEmpty()) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(bans));
        } else {
            resp.getWriter().write("fail");
        }
    }

}
