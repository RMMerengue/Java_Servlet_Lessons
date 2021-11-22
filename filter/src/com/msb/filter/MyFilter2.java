package com.msb.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("i am doFilter2");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("doFilter2 complete");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("i am init filter2");
    }

    @Override
    public void destroy() {
        System.out.println("i am destroy2");
        Filter.super.destroy();
    }
}
