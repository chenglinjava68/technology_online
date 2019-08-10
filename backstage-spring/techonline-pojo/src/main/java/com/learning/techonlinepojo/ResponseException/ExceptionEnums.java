package com.learning.techonlinepojo.ResponseException;

/**
 * @author Jaywatson
 * @version 1.0.0
 * @ClassName ResponseEnums.java
 * @Description TODO
 * @createTime 2019年07月29日 21:00:00
 */
public enum ExceptionEnums {
    /* 成功状态码 */
    SUCCESS("200", "操作成功"),

    /* 服务器错误 */
    SEVER_ERROR("00001","服务器异常"),
    MYBATIS_ERROR("00002","Mybatis未绑定"),

    /* 参数错误：10001-19999 */
    PARAM_ILLAGLE("10001", "参数无效"),
    PARAM_VALID_FAIL("10002", "参数校验不通过"),

    /* 用户错误：20001-29999*/
    USER_UNLOGIN("20001", "用户未登录"),
    USER_FAIL("20002", "账号不存在或密码错误"),
    USER_FOBBIDEN("20003", "用户已被禁用"),
    USER_NAME_EXIST("20004", "用户名已存在"),
    USER_NICKNAME_EXIST("20005", "用户昵称已存在"),
    USER_TOKENE_RROR("20006", "用户token异常"),

    /* 业务错误：30001-39999 */
    METHOD_NOT_ALLOWED("30001", "某业务出现问题"),

    /* 系统错误：40001-49999 */
    SYSTEM_NO_PERMISSION("40001", "系统繁忙，请稍后重试"),

    /* 数据错误：50001-599999 */
    DATA_NO_RECORD("50001", "数据未找到"),
    DATA_ERROR("50002", "数据有误"),
    DATA_EXIST("50003", "数据已存在"),
    DATABASE_ERROR("50004","数据库异常"),

    /* 接口错误：60001-69999 */
    API_INSIDE_ERROR("60001", "内部系统接口调用异常"),
    API_OUTSIDE_ERROR("60002", "外部系统接口调用异常"),
    API_FOBBIDEN("60003", "该接口禁止访问"),
    API_ADDRESS_INVALID ("60004", "接口地址无效"),
    API_TIMEOUT("60005", "接口请求超时");

    private String code;
    private String msg;
    private ExceptionEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
