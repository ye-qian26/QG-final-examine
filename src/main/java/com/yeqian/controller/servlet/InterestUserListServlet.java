package com.yeqian.controller.servlet;

import com.alibaba.fastjson.JSON;
import com.yeqian.pojo.InterestPlateList;
import com.yeqian.pojo.InterestUserList;
import com.yeqian.service.InterestPlateListService;
import com.yeqian.service.InterestUserListService;
import com.yeqian.service.impl.InterestPlateListServiceImpl;
import com.yeqian.service.impl.InterestUserListServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/interestUserListServlet/*")
public class InterestUserListServlet extends BaseServlet {
    InterestUserListService interestUserListService = new InterestUserListServiceImpl();
    /**
     * 根据 用户id 和 被关注用户id 查询关注列表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectInterestUserListByUserIdAndInterestedUserId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _userId = req.getParameter("userId");
        String _interestedUserId = req.getParameter("interestedUserId");
        //3.转换数据
        Integer userId = JSON.parseObject(_userId, Integer.class);
        Integer interestedUserId = JSON.parseObject(_interestedUserId, Integer.class);
        //4.执行service方法
        InterestUserList interestUserList = interestUserListService.selectByUserIdAndInterestedUserId(userId, interestedUserId);
        //5.响应数据
        if (interestUserList != null){
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(interestUserList));
        } else {
            resp.getWriter().write("fail");
        }
    }

    /**
     * 添加关注用户列表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addInterestUserList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        InterestUserList interestUserList = JSON.parseObject(jsonString, InterestUserList.class);
        //4.执行service方法
        interestUserListService.addInterestPlateList(interestUserList);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 删除关注列表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deleteInterestUserList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        InterestUserList interestUserList = JSON.parseObject(jsonString, InterestUserList.class);
        //4.执行service方法
        interestUserListService.deleteInterestPlateList(interestUserList);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 根据 用户id 查询 关注用户列表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectInterestUserListByUserId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _userId = req.getParameter("userId");
        //3.转换数据
        Integer userId = JSON.parseObject(_userId, Integer.class);
        //4.执行service方法
        List<InterestUserList> interestUserLists = interestUserListService.selectByUserId(userId);
        //5.响应数据
        if (interestUserLists != null){
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(interestUserLists));
        } else {
            resp.getWriter().write("fail");
        }
    }

}
