package com.msb;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class servletContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");

        //get servletContext
        ServletContext context = this.getServletContext();
        ServletContext context1 = this.getServletConfig().getServletContext();
        ServletContext context2 = request.getSession().getServletContext();

        context.setAttribute("111","zhangsan");

        //get parameters from web.xml
        String value = context.getInitParameter("beijing");
        System.out.println(value);

        String path = context.getRealPath("web.xml");
        String path2 = context.getContextPath();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
