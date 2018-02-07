package com.shine.hisip.common.response.enumeration;

/**
 * Created by Hyun on 2017.3.10.
 * 公共状态码及状态描述信息
 */
public enum ResponseStatus {

    SUCCESS("000000", "操作成功"),
    SUCCESS_DELAY("000506", "操作成功"),

    TOKEN_INVALID("100002", "安全校验失败"),
    LOGIN_ERROR("100003", "用户名和密码无效"),
    UPDATE_PASSWORD_ERROR("100004", "密码修改失败"),
    PARAM_MISSED("100005", "参数缺失"),
    PARAM_INVALID("100006", "参数无效"),

    PSAM_STOP("200001","终端停用"),
    PSAM_ERROR_REQUEST("200002","终端非法请求"),
    DEVICEID_FORBIDDEN("200003","终端禁用"),
    PSAM_INVALID("200004", "无法识别PSAM卡"),
    PSAM_FORBIDDEN("200005","PSAM卡禁用"),

    NETWORK_ERROR("300001", "网络异常"),
    SDK_PARSE_ERROR("300002", "SDK解析异常"),
    UNKOWN_ERROR("300003", "未知异常"),
    NO_DATA("300004", "服务器暂无数据可以获取或请求条件有误"),
    SAVE_DATA_ERROE("300005", "数据保存失败"),

    TELNUM_INVALID0("400000","输入的充值号码不是电信号码"),
    TELNUM_INVALID1("400001","输入的充值号码不是联通号码"),
    TELNUM_INVALID2("400002","输入的充值号码不是移动号码"),


    OPRERATE_FAILED("999999", "操作失败");

    private String code;
    private String note;

    private ResponseStatus(String code, String note) {
        this.code = code;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public String getCode() {
        return code;
    }

    public Integer getValue() {
        return this.ordinal();
    }

    public String getOrdinalStr() {
        return String.valueOf(this.ordinal());
    }

    public static ResponseStatus returnType(int ordinal) {
        return ResponseStatus.values()[ordinal];
    }
}
