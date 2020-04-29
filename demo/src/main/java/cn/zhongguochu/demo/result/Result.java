package cn.zhongguochu.demo.result;

import java.util.HashMap;

public class Result<T> {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态信息
     */
    private String msg;

    /**
     * 具体错误信息
     */
    private String err = "";
    /**
     * @desc 成功时返回的数据
     */
    private T data = (T) new HashMap<>(0);

    
	public Result() {
        this.code = StatusEnum.SUCCESS.code;
        this.msg = StatusEnum.SUCCESS.msg;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data == null ? (T) new HashMap<>(0) : data;
        return this;
    }

    public String getErr() {
        return err;
    }

    public Result<T> setErr(String err) {
        this.err = err;
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", err='" + err + '\'' +
                '}';
    }
}
