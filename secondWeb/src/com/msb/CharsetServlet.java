package com.msb;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CharsetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET");
        String name = request.getParameter("name");
        System.out.println(new String(name.getBytes("iso-8859-1"),"utf-8"));
        System.out.println(name);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST");
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        System.out.println(name);
        response.setCharacterEncoding("gbk");
        response.getWriter().write("欢迎你");
    }
}
