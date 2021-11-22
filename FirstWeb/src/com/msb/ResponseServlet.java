package com.msb;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("this is get");
        response.setHeader("hehe", "haha");
        response.addHeader("beijing", "shanghai");

        response.sendError(404, "not found");
        response.getWriter().write("<b>java is easy</b>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
        System.out.println("this id post");
    }
}
