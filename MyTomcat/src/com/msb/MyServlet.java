package com.msb;

public class MyServlet extends MyHttpServlet{
    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception {
        response.write("mytomcat");
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws Exception {
        response.write("post tomcat");
    }
}
