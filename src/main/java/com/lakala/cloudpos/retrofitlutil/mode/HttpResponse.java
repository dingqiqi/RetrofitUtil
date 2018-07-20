package com.lakala.cloudpos.retrofitlutil.mode;

/**
 * Created by dingqq on 2018/7/16.
 */

public class HttpResponse {
    private int code;

    private String body;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "code=" + code +
                ", body='" + body + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
