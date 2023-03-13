package com.example.demo.controller;

import com.example.demo.common.AjaxResult;
import com.example.demo.common.Constant;
import com.example.demo.common.SecurityUtil;
import com.example.demo.model.UserInfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/reg")
    public Object reg(String username, String password) {
        // 1.非空效验
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            return AjaxResult.fail(-1, "非法的参数请求");
        }
        // 2. 进行添加操作
        int result = userService.add(username,
                SecurityUtil.encrypt(password)); // 密码加盐
        if (result == 1) {
            return AjaxResult.success("添加成功！", 1);
        } else {
            return AjaxResult.fail(-1, "数据库添加出错");
        }
    }

    /**
     * 登录功能
     *
     * @param username
     * @param password
     * @return 如果用户和密码都正确，返回1；如果用户名或密码为空，或不正确，那么返回非1
     */
    @RequestMapping("/login")
    public int login(HttpServletRequest request, String username, String password) {
        // 1.非空效验
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            // 参数有误
            return 0;
        }
        // 2. 进行查询操作
        UserInfo userInfo = userService.getUserByName(username);
        if (userInfo == null || userInfo.getId() <= 0) { // userinfo 无效
            // 用户名错误
            return -1;
        } else {
            boolean result = SecurityUtil.decrypt(password, userInfo.getPassword());
            if (result) {
                // 用户名和密码正确
                // 将 userinfo 保存到 session 中
                HttpSession session = request.getSession();
                session.setAttribute(Constant.SESSION_USERINFO_KEY, userInfo);
                return 1;
            }
        }
        return -1;
    }

    @RequestMapping("/myinfo")
    public UserInfo myInfo(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null &&
                session.getAttribute(Constant.SESSION_USERINFO_KEY) != null) {
            return (UserInfo) session.getAttribute(Constant.SESSION_USERINFO_KEY);
        }
        return null;
    }

    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public boolean logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null &&
                session.getAttribute(Constant.SESSION_USERINFO_KEY) != null) {
            // 异常 session 中当前登录的用户
            session.removeAttribute(Constant.SESSION_USERINFO_KEY);
        }
        return true;
    }

    @RequestMapping("/hi")
    public String sayHi() {
        return "Hi,Blog.";
    }

}
