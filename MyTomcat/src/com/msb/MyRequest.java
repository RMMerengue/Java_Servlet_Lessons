package com.msb;

import java.io.InputStream;

public class MyRequest {
    //request method GET/POST
    private String requestMethod;
    //requests url
    private String requestUrl;

    public MyRequest(InputStream inputStream) throws Exception{
        //buffer zone
        byte[] buffer = new byte[1024];
        //get stream length
        int len = 0;
        //define request variable
        String str = null;

        if((len = inputStream.read(buffer)) >0){
            str = new String(buffer, 0, len);
        }
        //GET/ HTTP/1.1
        String data = str.split("/n")[0];
        String[] params = data.split(" ");
        this.requestMethod = params[0];
        this.requestUrl = params[1];
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
