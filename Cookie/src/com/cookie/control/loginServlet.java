package com.cookie.control;

import com.cookie.entity.User;
import com.cookie.service.UserService;
import com.cookie.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("enter login");

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //get request
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        User user = new User(name, pwd);
        User u = userService.check(user);
        System.out.println(u.toString());

        if(u!=null){
            //request.getRequestDispatcher("hello").forward(request,response);
            Cookie cookie = new Cookie("uid", u.getId()+"");
            cookie.setMaxAge(7*24*3600);
            response.addCookie(cookie);
            response.sendRedirect("hello");
        }else{
            request.setAttribute("str","username or password error");
            request.getRequestDispatcher("page").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
