package com.msb.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener2 implements HttpSessionListener, ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("cnt",0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
        System.out.println("servletContext destroy");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSessionListener.super.sessionCreated(se);
        ServletContext sc = se.getSession().getServletContext();
        int cnt = (int)sc.getAttribute("cnt");
        sc.setAttribute("cnt", ++cnt);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSessionListener.super.sessionDestroyed(se);
        ServletContext sc = se.getSession().getServletContext();
        int cnt = (int)sc.getAttribute("cnt");
        sc.setAttribute("cnt", --cnt);
    }
}
