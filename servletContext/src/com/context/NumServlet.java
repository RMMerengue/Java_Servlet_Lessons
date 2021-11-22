package com.context;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class NumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
         response.setContentType("text/html;charset=utf-8");

         ServletContext context = this.getServletContext();
         Integer num = (Integer)context.getAttribute("num");
         if(num==null){
             context.setAttribute("num",1);
         }else{
             num++;
             context.setAttribute("num",num);
         }
         PrintWriter out = response.getWriter();
         out.write("<html>");
         out.write(" <head>");
         out.write("</head>");
         out.write(" <body>");
         out.write("user request times:" + context.getAttribute("num"));
         out.write("</body>");
         out.write("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
