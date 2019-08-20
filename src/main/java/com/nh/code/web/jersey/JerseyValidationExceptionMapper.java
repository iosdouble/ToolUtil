package com.nh.code.web.jersey;

import com.nh.code.web.resp.generator.IWsRsResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.Iterator;

/**
 * @Classname JerseyValidationExceptionMapper
 * @Description TODO
 * @Date 2019/8/20 12:08 PM
 * @Created by nihui
 */
public class JerseyValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Autowired(
            required = false
    )
    protected IWsRsResponseGenerator wsrsResponseGenerator;

    public JerseyValidationExceptionMapper() {
    }

    public Response toResponse(ConstraintViolationException constraintViolationException) {
        Response.Status status = Response.Status.OK;
        Iterator<ConstraintViolation<?>> iterator = constraintViolationException.getConstraintViolations().iterator();
        ConstraintViolation<?> constraintViolation = (ConstraintViolation)iterator.next();
        String errorMsg = constraintViolation.getMessage();
        Exception exception = new Exception(errorMsg);
        Response response = this.wsrsResponseGenerator.doResponse(status, exception, (Object)null);
        return response;
    }
}
