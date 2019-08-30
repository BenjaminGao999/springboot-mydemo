package com.example.springboot.misc.misc.exception;

public enum ErrorCodeEnum {

    /*** －－－－－－基础错误码 错误码范围 401-599－－－－－－*/
    SUCCESS(0, "成功"),
    FAIL(-1, "失败"),
    ARGUEMENT_ERROR(401, "参数错误"),
    ARGUEMENT_VALUE_ERROR(402, "参数值错误"),
    ARGUMENT_VALID_ERROR(403, "参数校验出错"),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED(404, "请求方式出错"),
    UNLOIGN(501, "请登录"),
    SYSTEM_INTERNAL_ERROR(502, "系统内部错误"),
    SERVICE_UNSUPPORT(503, "业务不支持"),
    LOGOUT_FAIL(504, "注销失败"),
    ACCOUNT_NOT_FOUND(505, "账号不存在"),
    /*** －－－－－－基础错误码 END－－－－－－*/


    /*** －－－－－－业务错误码 错误码范围 4001-4100－－－－－－*/

    ACCOUNT_OR_PASSWORD_ERROR(4003, "账号或密码错误"),
    USERNAME_REGISTERED(4004, "用户名已注册"),
    PHONE_REGISTERED(4005, "手机号已注册"),
    PHONE_FORMAT_ERROR(4006, "手机号格式错误"),
    CAPTCHA_ERROR(4007, "验证码错误"),
    PHONE_NOT_REGISTERED(4008, "手机号未注册"),


    PASSWORD_NOT_SETTING(4024, "登录密码未设置"),
    CAPTCHA_INVALID(4026, "验证码已失效"),

    CAPTCHA_SEND_FAIL(4036, "验证码发送失败"),
    CAPTCHA_SEND_CLOSE(4037, "验证码发送功能已关闭"),
    CONFIRM_PASSWORD_NOT_EQULE(4038, "两次密码输入不一致"),
    OLD_PASSWORD_ERROR(4039, "原密码错误"),
    PASSWORD_NOT_EQULE_OLDPASSWORD(4040, "新密码不能与旧密码一致"),


    PHONE_FORBIDDEN(4053, "您的手机号已被禁用!"),


    USER_NOT_EXIST(4064, "用户不存在"),

    /*** －－－－－－其他错误码 错误码范围 9001-9999－－－－－－*/
    VERIFY_GIGN_FAIL(9001, "验签失败");


    private int code;

    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    ErrorCodeEnum() {
    }
}