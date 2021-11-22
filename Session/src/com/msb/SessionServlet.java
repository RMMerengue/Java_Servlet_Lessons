package com.msb;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        session.setAttribute("111","zhangsan");
        response.getWriter().write("learn session");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
