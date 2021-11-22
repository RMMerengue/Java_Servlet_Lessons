package com.msb.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class loginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("do loginFilter");

        HttpSession session = ((HttpServletRequest)servletRequest).getSession();
        if(session.getAttribute("user")==null){
            ((HttpServletResponse)servletResponse).sendRedirect("login.jsp");
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }

        System.out.println("loginFilter complete");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("loginFilter init");
    }

    @Override
    public void destroy() {
        System.out.println("loginFilter destroy");
        Filter.super.destroy();
    }
}
