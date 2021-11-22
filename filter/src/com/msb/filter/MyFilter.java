package com.msb.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("i am doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("doFilter complete");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("i am init filter");
    }

    @Override
    public void destroy() {
        System.out.println("i am destroy");
        Filter.super.destroy();
    }
}
