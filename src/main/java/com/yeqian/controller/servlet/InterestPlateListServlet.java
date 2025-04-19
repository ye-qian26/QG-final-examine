package com.yeqian.controller.servlet;

import com.alibaba.fastjson.JSON;
import com.yeqian.pojo.Audit;
import com.yeqian.pojo.InterestPlateList;
import com.yeqian.service.AuditService;
import com.yeqian.service.InterestPlateListService;
import com.yeqian.service.impl.AuditServiceImpl;
import com.yeqian.service.impl.InterestPlateListServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/interestPlateListServlet/*")
public class InterestPlateListServlet extends BaseServlet {
    InterestPlateListService interestPlateListService = new InterestPlateListServiceImpl();
    /**
     * 根据 用户id 和 板块id 查询关注列表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectInterestPlateListByUserIdAndPlateId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _userId = req.getParameter("userId");
        String _plateId = req.getParameter("plateId");
        //3.转换数据
        Integer userId = JSON.parseObject(_userId, Integer.class);
        Integer plateId = JSON.parseObject(_plateId, Integer.class);
        //4.执行service方法
        InterestPlateList interestPlateList = interestPlateListService.selectByUserIdAndPlateId(userId, plateId);
        //5.响应数据
        if (interestPlateList != null){
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(interestPlateList));
        } else {
            resp.getWriter().write("fail");
        }
    }

    /**
     * 添加关注列表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addInterestPlateList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        InterestPlateList interestPlateList = JSON.parseObject(jsonString, InterestPlateList.class);
        //4.执行service方法
        interestPlateListService.addInterestPlateList(interestPlateList);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 删除关注列表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deleteInterestPlateList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        InterestPlateList interestPlateList = JSON.parseObject(jsonString, InterestPlateList.class);
        //4.执行service方法
        interestPlateListService.deleteInterestPlateList(interestPlateList);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 根据 用户id 查询 关注板块列表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectInterestPlateListByUserId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String _userId = req.getParameter("userId");
        //3.转换数据
        Integer userId = JSON.parseObject(_userId, Integer.class);
        //4.执行service方法
        List<InterestPlateList> interestPlateLists = interestPlateListService.selectByUserId(userId);
        //5.响应数据
        if (interestPlateLists != null){
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(interestPlateLists));
        } else {
            resp.getWriter().write("fail");
        }
    }

}
