package cn.zhongguochu.demo.controller;

import cn.zhongguochu.demo.result.Result;
import cn.zhongguochu.demo.service.HelloService;
import cn.zhongguochu.demo.service.Test1Service;
import cn.zhongguochu.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private HelloService service;

    @Autowired
    private Test1Service test1Service;

    @RequestMapping("/hello")
    public Result hello() {
        return service.hello();
    }

    @RequestMapping("/test")
    public Result test() {
        return test1Service.testA();
    }
}
