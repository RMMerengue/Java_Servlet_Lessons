package com.msb;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        String str = (String)session.getAttribute("111");
        System.out.println(str);
        response.getWriter().write(str);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
