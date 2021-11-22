package com.msb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

public class RequestServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST");
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET");
        //get request method
        String method = request.getMethod();
        System.out.println(method);
        //get request url(uniform resource locator)
        StringBuffer url = request.getRequestURL();
        System.out.println(url);
        //get request uri(uniform resource identifier)
        String uri = request.getRequestURI();
        System.out.println(uri);
        //get reuest schema
        String schema = request.getScheme();
        System.out.println(schema);

        //get request header
        //get value according to key
        String userAgent = request.getHeader("User-Agent");
        System.out.println(userAgent);
        //get all keys and values
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println(key+":"+value);
        }

        //get user request
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String fav = request.getParameter("fav");
        System.out.println(name+":"+pwd+":"+fav);

        //get all user request key
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            System.out.println(parameterNames.nextElement());
        }

        String[] parameterValues = request.getParameterValues("fav");
        for(String str:parameterValues){
            System.out.println("fav:"+str);
        }

        //other method
        String remoteAddress  = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        System.out.println(remoteAddress+":"+remoteHost+":"+remotePort);

        String localAddr = request.getLocalAddr();
        String localName = request.getLocalName();
        System.out.println(localAddr+":"+localName);

    }
}
