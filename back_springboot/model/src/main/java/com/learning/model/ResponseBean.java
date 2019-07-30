package com.learning.model;

import com.learning.model.enums.ResponseEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Jaywatson
 * @version 1.0.0
 * @ClassName ResponseBean.java
 * @Description TODO
 * @createTime 2019年07月28日 23:39:00
 */

@ApiModel("统一响应封装类")
public class ResponseBean <T>{
    @ApiModelProperty(value = "是否成功", name = "success",dataType = "boolen", example = "true")
    private boolean success;
    @ApiModelProperty(value = "数据集", name = "data",dataType = "T", example = "")
    private T data;
    @ApiModelProperty(value = "结果编码", name = "code",dataType = "String", example = "200")
    private String code;
    @ApiModelProperty(value = "返回信息", name = "message",dataType = "String", example = "成功")
    private String message;
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", data=" + data +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public ResponseBean(){}

    public ResponseBean(boolean success, T data) {
        super();
        this.success = success;
        this.data = data;
    }
    public ResponseBean(boolean success, T data, String code, String message) {
        super();
        this.success = success;
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public ResponseBean(boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
    public ResponseBean(boolean success, ResponseEnums enums){
        this.success=success;
        this.code=enums.getCode();
        this.message=enums.getMsg();
    }
    public ResponseBean(boolean success,T data,ResponseEnums enums){
        this.success=success;
        this.data=data;
        this.code=enums.getCode();
        this.message=enums.getMsg();
    }

}
