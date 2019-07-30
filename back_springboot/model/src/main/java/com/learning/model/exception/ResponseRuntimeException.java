package com.learning.model.exception;

import com.learning.model.enums.ResponseEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Jaywatson
 * @version 1.0.0
 * @ClassName ResponseRuntimeException.java
 * @Description TODO
 * @createTime 2019年07月30日 23:31:00
 */
@ApiModel("封装异常响应类")
public class ResponseRuntimeException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "token", name = "token",dataType = "String", example = "xxx")
    protected String code;
    @ApiModelProperty(value = "token", name = "token",dataType = "String", example = "xxx")
    protected String msg;
    @ApiModelProperty(value = "日志信息", name = "logo",dataType = "String", example = "xxx")
    protected String logo;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }

    public ResponseRuntimeException(ResponseEnums enums, String logo) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
        this.logo = logo;
    }

    public ResponseRuntimeException(ResponseEnums enums) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }

    public ResponseRuntimeException() {
        super();
    }

    public ResponseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResponseRuntimeException(String message) {
        super(message);
    }
}
