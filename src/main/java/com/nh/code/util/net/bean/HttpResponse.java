package com.nh.code.util.net.bean;

import java.io.Serializable;


public class HttpResponse implements Serializable {
    private static final long serialVersionUID = 8140069301565768594L;
    private int status;
    private String content;

    public HttpResponse() {
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString() {
        return "HttpResponse [status=" + this.status + ", content=" + this.content + "]";
    }
}