package com.msb;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class servletContextServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        String value = (String)context.getAttribute("111");
        System.out.println(value);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
