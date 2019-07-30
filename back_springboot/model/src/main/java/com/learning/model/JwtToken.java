package com.learning.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Jaywatson
 * @version 1.0.0
 * @ClassName JwtToken.java
 * @Description TODO
 * @createTime 2019年07月28日 23:39:00
 */
@ApiModel("JwtToken类")
public class JwtToken {
    @ApiModelProperty(value = "token", name = "token",dataType = "String", example = "xxx")
    private String token;

    public String getToken() {
        return token;
    }

}
