package com.session.control;

import com.session.entity.User;
import com.session.service.UserService;
import com.session.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
            //response.sendRedirect("hello");
            HttpSession session = request.getSession();
            session.setAttribute("name", u.getName());
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
