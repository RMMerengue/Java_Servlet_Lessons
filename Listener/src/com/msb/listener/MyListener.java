package com.msb.listener;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;

public class MyListener implements ServletRequestListener, ServletRequestAttributeListener, ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request destroy" + new Date());
        ServletRequestListener.super.requestDestroyed(sre);
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request init" + new Date());
        ServletRequestListener.super.requestInitialized(sre);
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        ServletRequestAttributeListener.super.attributeAdded(srae);
        System.out.println("add data to request");
        System.out.println(srae.getName());
        System.out.println(srae.getValue());

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        ServletRequestAttributeListener.super.attributeRemoved(srae);
        System.out.println("remove data from request");
        System.out.println(srae.getName());
        System.out.println(srae.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        ServletRequestAttributeListener.super.attributeReplaced(srae);
        System.out.println("replace request attribute");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("servletContext init");
        ServletContextListener.super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servletContext destroy");
        ServletContextListener.super.contextDestroyed(sce);
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("add attribute to servletContext");
        ServletContextAttributeListener.super.attributeAdded(scae);

        System.out.println(scae.getName());
        System.out.println(scae.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("remove attribute from servletContext");
        ServletContextAttributeListener.super.attributeRemoved(scae);
        System.out.println(scae.getName());
        System.out.println(scae.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("replace attribute from servletContext");
        ServletContextAttributeListener.super.attributeReplaced(scae);
        System.out.println(scae.getName());
        System.out.println(scae.getValue());
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("create session");
        HttpSessionListener.super.sessionCreated(se);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("destroy session");
        HttpSessionListener.super.sessionDestroyed(se);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        HttpSessionAttributeListener.super.attributeAdded(se);
        System.out.println("add attribute to session");
        System.out.println(se.getName());
        System.out.println(se.getValue());

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        HttpSessionAttributeListener.super.attributeRemoved(se);
        System.out.println("remove attribute from session");
        System.out.println(se.getName());
        System.out.println(se.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        HttpSessionAttributeListener.super.attributeReplaced(se);
        System.out.println("replace attribute from session");
        System.out.println(se.getName());
        System.out.println(se.getValue());
    }
}
