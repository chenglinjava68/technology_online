package com.learning.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Jaywatson
 * @version 1.0.0
 * @ClassName SpringExceptionHandle.java
 * @Description TODO
 * @createTime 2019年08月01日 00:28:00
 */
@RestControllerAdvice(annotations={RestController.class, Controller.class})
public class SpringExceptionHandle {
    private static final Logger logger = LoggerFactory.getLogger(SpringExceptionHandle.class);
    /**
     * 请求参数类型错误异常的捕获
     * @param e
     * @return
     */
    @ExceptionHandler(value={BindException.class})
    @ResponseBody
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public ResponseBean<String> badRequest(BindException e){
        logger.error("occurs error when execute method ,message {}",e.getMessage());
        return new ResponseBean<>(false, UnicomResponseEnums.BAD_REQUEST);
    }
}
