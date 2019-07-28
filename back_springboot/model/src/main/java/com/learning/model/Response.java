package com.learning.model;

/**
 * @author Jaywatson
 * @version 1.0.0
 * @ClassName Response.java
 * @Description TODO
 * @createTime 2019年07月28日 23:39:00
 */
public class Response <T>{
    private boolean success;
    private T data;
    private String code;
    private String message;

}
