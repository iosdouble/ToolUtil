package com.nh.code.web.resp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nh.code.exception.ParentException;
import com.nh.code.exception.ParentRuntimeException;
import com.nh.code.exception.bean.ExceptionMsg;

import java.util.Date;

/**
 * @Classname ResultResp
 * @Description TODO
 * @Date 2019/8/20 12:18 PM
 * @Created by nihui
 */
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class ResultResp<T> extends AbsJsonResp {
    private static final long serialVersionUID = 8262436911538688064L;
    @JsonProperty("date")
    private Date date = new Date();
    @JsonProperty("status")
    private String status = "normal";
    @JsonProperty("exception")
    private ExceptionMsg exceptionMsg;
    @JsonProperty("response")
    private T response;

    public ResultResp() {
    }

    @JsonIgnore
    public void setException(ParentException parentException) {
        this.exceptionMsg = parentException.getExceptionMsg();
    }

    @JsonIgnore
    public void setException(ParentRuntimeException parentRuntimeException) {
        this.exceptionMsg = parentRuntimeException.getExceptionMsg();
    }

    public Date getDate() {
        return this.date;
    }

    public String getStatus() {
        return this.status;
    }

    public ExceptionMsg getExceptionMsg() {
        return this.exceptionMsg;
    }

    public T getResponse() {
        return this.response;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setExceptionMsg(ExceptionMsg exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
