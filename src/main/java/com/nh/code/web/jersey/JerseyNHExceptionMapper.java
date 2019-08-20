package com.nh.code.web.jersey;

import com.nh.code.web.resp.generator.IWsRsResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


/**
 * @Classname JerseyNHExceptionMapper
 * @Description TODO
 * @Date 2019/8/20 12:02 PM
 * @Created by nihui
 */
public class JerseyNHExceptionMapper {
    @Autowired(
            required = false
    )
    protected IWsRsResponseGenerator wsrsResponseGenerator;

    public JerseyNHExceptionMapper() {
    }

    public Response toResponse(Throwable throwable) {
        Status status = Status.OK;
        Response response = this.wsrsResponseGenerator.doResponse(status, throwable, (Object)null);
        return response;
    }
}
