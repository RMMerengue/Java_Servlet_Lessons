package com.msb;

import com.msb.entity.Address;
import com.msb.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ELServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        System.out.println(name);
        System.out.println(pwd);

        request.setAttribute("aa","aaaa");

        User user = new User(1,"zhangsan", new Address("beijing","beijing", "haidian"));
        User user2 = new User(2,"lisi", new Address("hebei","handan", "wuan"));

        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        request.setAttribute("user", user);

        request.setAttribute("list", list);

        HashMap<String,String> map = new HashMap<>();
        map.put("beijing","beijing");
        map.put("hebei","hebei");
        request.setAttribute("map",map);

        request.getRequestDispatcher("el.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
