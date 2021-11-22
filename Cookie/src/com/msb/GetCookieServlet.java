package com.msb;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");

        Cookie[] cookies = request.getCookies();
        if(cookies.length>0){
            for (Cookie c: cookies ) {
                String key = c.getName();
                String value = c.getValue();
                System.out.println(key+":"+value);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
