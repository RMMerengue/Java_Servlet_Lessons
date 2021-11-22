package com.cookie.control;

import com.cookie.entity.User;
import com.cookie.service.UserService;
import com.cookie.service.impl.UserServiceImpl;
import com.sun.javaws.IconUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CookieProjectServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");

        Cookie[] cookies = request.getCookies();
        if(cookies.length>1){
            for(Cookie c:cookies){
                String key = c.getName();
                String value = c.getValue();
                System.out.println(key+":"+value);
                if(key.equals("JSESSIONID")){
                    continue;
                }
                if("uid"!=null){
                    User u = userService.getUserById(Integer.valueOf(value));
                    if(u!=null){
                        response.sendRedirect("hello");
                    }else{
                        response.sendRedirect("page");
                    }
                }else{
                    response.sendRedirect("page");
                }
            }
        }else{
            response.sendRedirect("page");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
