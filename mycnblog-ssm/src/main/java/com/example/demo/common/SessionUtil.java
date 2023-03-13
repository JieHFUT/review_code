package com.example.demo.common;

import com.example.demo.model.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {

    /**
     * 查询当前登录用户的 session 信息
     *
     * @param request
     * @return
     */
    public static UserInfo getLoginUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null &&
                session.getAttribute(Constant.SESSION_USERINFO_KEY) != null) {
            return (UserInfo) session.getAttribute(Constant.SESSION_USERINFO_KEY);
        }
        return null;
    }

}
