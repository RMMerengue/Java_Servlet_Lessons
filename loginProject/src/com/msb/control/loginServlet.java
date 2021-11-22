package com.msb.control;

import com.msb.entity.User;
import com.msb.service.UserService;
import com.msb.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class loginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET");

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //get request
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        User user = new User(name, pwd);
        User u = userService.check(user);
        System.out.println(u);

        if(u!=null){
            //request.getRequestDispatcher("hello").forward(request,response);
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
