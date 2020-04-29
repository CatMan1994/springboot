package cn.zhongguochu.demo.controller;

import cn.zhongguochu.demo.result.Result;
import cn.zhongguochu.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private HelloService service;

    @RequestMapping("/hello")
    public Result hello() {
        return service.hello();
    }
}
