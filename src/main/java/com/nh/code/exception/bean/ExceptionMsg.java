package com.nh.code.exception.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Classname ExceptionMsg
 * @Description TODO
 * @Date 2019/8/20 2:31 PM
 * @Created by nihui
 */
@ApiModel(
        description = "异常处理信息类"
)
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class ExceptionMsg implements Serializable {
    private static final long serialVersionUID = -7447689818750410956L;
    @ApiModelProperty(
            value = "错误 ID",
            required = true,
            example = "UUID",
            position = 1
    )
    @JsonProperty("error_id")
    private String errorId;
    @ApiModelProperty(
            value = "错误 code",
            required = true,
            example = "100110121",
            position = 2
    )
    @JsonProperty("error_code")
    private String errorCode;
    @ApiModelProperty(
            value = "错误信息",
            required = true,
            example = "在注册时候用户名不能为空",
            position = 3
    )
    @JsonProperty("error_msg")
    private String errorMsg;

    public ExceptionMsg() {
    }

    public String getErrorId() {
        return this.errorId;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
