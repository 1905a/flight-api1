package com.fh.code;

public enum ResponseEnum {

    SUCCESS(200,"操作成功"),
    ERROR(500,"操作失败"),
    CODE_ERROR(1001,"验证码错误"),
    PASSWORD_ERROR(502,"密码错误"),
    USER_IS_NULL(503,"用户不存在"),
    USER_IS_NOT_EXIST(503,"用户不存在"),
    PASSWORD_IS_NULL(504,"密码不对"),
    TOKEN_IS_NULL(505,"头信息为空"),
    TOKEN_IS_SHORT_OF(506,"头信息不全"),
    TOKEN_VERIFY_ERROR(507,"加密异常"),
    TOKEN_IS_CHANGED(508,"头信息改变"),
    TOKEN_IS_EXPIRED(509,"redis中数据过期"),
    orderItem_IS_NULL(510,"传过来的票为空"),
    CART_IS_NOT_EXISTED(5011,"当前用户没有购物车"),
    REPETITIVE_OPERATION(507,"重复操作"),
    TOKEN_IS_ERROR(508,"token错误"),
    TOKEN(666,"头信息为空");

    private int code;
    private String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
