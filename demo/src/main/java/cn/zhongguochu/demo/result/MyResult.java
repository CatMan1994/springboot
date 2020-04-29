package cn.zhongguochu.demo.result;

public class MyResult {

    private MyResult() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 自定义消息状态
     *
     * @param code 状态码
     * @param msg  状态信息
     * @return 封装结果
     */
    public static Result custom(Integer code, String msg) {
        return new Result(code, msg);
    }

    /**
     * 自定义消息状态
     *
     * @param statusEnum 状态枚举
     * @return 封装结果
     */
    public static Result custom(StatusEnum statusEnum) {
        return custom(statusEnum.getCode(), statusEnum.getMsg());
    }

    /**
     * 操作成功
     *
     * @return 封装结果
     */
    public static Result success() {
        return custom(StatusEnum.SUCCESS);
    }

    /**
     * 操作成功
     *
     * @param data 成功时返回的数据
     * @return 封装结果
     */
    public static Result success(Object data) {
        return custom(StatusEnum.SUCCESS).setData(data);
    }

    public static Result error(StatusEnum tip, Exception e) {
        return custom(tip).setErr(e.getMessage());
    }

    /**
     * 操作数据状态
     *
     * @param expr 处理结果条数是否满足需求表达式 如 num > 0
     * @return 封装结果
     */
    public static Result status(boolean expr) {
        if (expr) {
            return success();
        } else {
            return custom(StatusEnum.OPT_FAIL);
        }
    }

    /**
     * 返回自定义信息
     *
     * @param expr
     * @param successResult
     * @param failResult
     * @return
     */
    public static Result status(boolean expr, Result successResult, Result failResult) {
        if (expr) {
            return successResult;
        } else {
            return failResult;
        }
    }

    public static Result tip(String tip) {
        return custom(StatusEnum.MISS_MUST_COND).setMsg(tip);
    }
    
    /**
     * @desc 失败的结果
     * @return
     */
    public static Result failResult() {
    	return new Result(StatusEnum.OPT_FAIL.code,StatusEnum.OPT_FAIL.msg);
    }
}
