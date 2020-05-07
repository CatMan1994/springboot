package cn.zhongguochu.demo.config;

import cn.zhongguochu.demo.result.MyResult;
import cn.zhongguochu.demo.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {RuntimeException.class})
    public Result RuntimeExceptionHandler(RuntimeException e) {
        return MyResult.tip("服务器开小差");
    }

}
