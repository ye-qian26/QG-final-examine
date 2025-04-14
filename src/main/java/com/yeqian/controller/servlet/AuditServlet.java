package com.yeqian.controller.servlet;

import com.alibaba.fastjson.JSON;
import com.yeqian.pojo.Audit;
import com.yeqian.pojo.User;
import com.yeqian.service.AuditService;
import com.yeqian.service.UserService;
import com.yeqian.service.impl.AuditServiceImpl;
import com.yeqian.service.impl.UserServiceImpl;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/auditServlet/*")
public class AuditServlet extends BaseServlet {
    AuditService auditService = new AuditServiceImpl();
    /**
     * 添加申请
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addAudit(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.解决乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转为Audit类
        Audit audit = JSON.parseObject(jsonString, Audit.class);
        //4.执行service方法
        auditService.addAudit(audit);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 查询所有申请
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectAllAudit(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.执行service方法查询
        List<Audit> audits = auditService.selectAllAudit();
        //2.解决resp乱码问题
        resp.setCharacterEncoding("utf-8");
        //3.响应数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(JSON.toJSONString(audits));
    }

    /**
     * 根据id删除申请表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deleteAuditById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.接收数据
        String _id = req.getParameter("id");
        //2.转换数据
        Integer id = JSON.parseObject(_id, Integer.class);
        //3.执行service方法
        auditService.deleteAuditById(id);
        //4.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 根据id删除申请表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void updateAuditStatus(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.接收数据
        String _id = req.getParameter("id");
        //2.转换数据
        Integer id = JSON.parseObject(_id, Integer.class);
        //3.执行service方法
        auditService.updateAuditStatus(id, 1);
        //4.响应数据
        resp.getWriter().write("success");
    }
}
