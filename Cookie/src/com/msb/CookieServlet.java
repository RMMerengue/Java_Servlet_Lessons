package com.msb;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");

        //creat cookie object
        Cookie cookie1 = new Cookie("001","beijing");
        Cookie cookie2 = new Cookie("002","shanghai");
        cookie1.setMaxAge(3*24*3600);
        cookie2.setPath("/cookie/abc");
        response.addCookie(cookie1);
        response.addCookie(cookie2);


        response.getWriter().write("learn cookie");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
