package com.cookie.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("enter page");

        String str = (String)request.getAttribute("str")==null ? "" : (String)request.getAttribute("str");
        System.out.println(str);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write("<head>");
        out.write("</head>");
        out.write("<body>");

        out.write("<form action='login' method='get'>");
        out.write("UserName:<input type='text' name='name' value=''><br/>");
        out.write("Password:<input type='text' name='pwd' value=''><br/>");
        out.write("<input type='submit' value='login'>");
        out.write("</form>");

        out.write("<font color='red' size='20px'>" + str +"</font>");

        out.write("</body>");
        out.write("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
