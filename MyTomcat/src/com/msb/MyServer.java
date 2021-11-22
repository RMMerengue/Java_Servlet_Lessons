package com.msb;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    /**
     * define recerve program, get socket request
     * @param port
     */
    public static void startServer(int port) throws Exception{
        //define server socket
        ServerSocket serverSocket = new ServerSocket(port);
        //difine client socket
        Socket socket = null;

        while(true){
            socket = serverSocket.accept();

            //get input stream and output stream
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            //define request object
            MyRequest request = new MyRequest(inputStream);
            //define response object
            MyResponse response = new MyResponse(outputStream);

            String clazz = new MyMapping().getMapping().get(request.getRequestUrl());
            if(clazz!=null){
                Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
                //create object according to myServletClass
                MyServlet myServlet = myServletClass.newInstance();
                myServlet.service(request, response);
            }
        }
    }

    public static void main(String[] args) {
        try{
            startServer(10086);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
