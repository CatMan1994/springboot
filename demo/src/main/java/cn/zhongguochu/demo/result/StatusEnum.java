package cn.zhongguochu.demo.result;

public enum StatusEnum {
    /**
     * 操作失败
     */
    OPT_FAIL(-2, "操作失败"),
    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 缺少必要条件
     */
    MISS_MUST_COND(1001, "缺少必要条件");

    /**
     * 状态码
     */
    public Integer code;
    /**
     * 状态信息
     */
    public String msg;

    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
