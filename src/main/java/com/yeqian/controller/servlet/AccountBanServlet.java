package com.yeqian.controller.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.yeqian.pojo.AccountBan;
import com.yeqian.pojo.ReportedUser;
import com.yeqian.service.AccountBanService;
import com.yeqian.service.ReportedUserService;
import com.yeqian.service.impl.AccountBanServiceImpl;
import com.yeqian.service.impl.ReportedUserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/accountBanServlet/*")
public class AccountBanServlet extends BaseServlet {
    AccountBanService accountBanService = new AccountBanServiceImpl();

    /**
     * 增加 账号封禁
     * @param req
     * @param resp
     * @throws Exception
     */
    public void addAccountBan(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        AccountBan accountBan = JSON.parseObject(jsonString, AccountBan.class);
        //4.执行service方法
        accountBanService.addAccountBan(accountBan);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 删除 账号封禁
     * @param req
     * @param resp
     * @throws Exception
     */
    public void deleteAccountBan(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        Integer banUserId = JSON.parseObject(jsonString, Integer.class);
        //4.执行service方法
        accountBanService.deleteAccountBan(banUserId);
        //5.响应数据
        resp.getWriter().write("success");
    }

    /**
     * 根据 被封禁的用户id 查询 账号封禁表
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectAccountBanByBanUserId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.处理乱码问题
        req.setCharacterEncoding("utf-8");
        //2.接收数据
        String jsonString = req.getReader().readLine();
        //3.转换数据
        Integer banUserId = JSON.parseObject(jsonString, Integer.class);
        //4.执行service方法
        AccountBan accountBan = accountBanService.selectAccountBanByBanUserId(banUserId);
        //5.响应数据
        if (accountBan != null) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(accountBan));
        } else {
            resp.getWriter().write("fail");
        }
    }

    /**
     * 查询 所有封禁账号
     * @param req
     * @param resp
     * @throws Exception
     */
    public void selectAllAccountBan(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1.执行service方法
        List<AccountBan> accountBans = accountBanService.selectAllAccountBan();
        //2.响应数据
        if (accountBans != null) {
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString(accountBans));
        } else {
            resp.getWriter().write("fail");
        }
    }


}
