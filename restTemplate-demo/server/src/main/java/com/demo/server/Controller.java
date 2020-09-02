package com.demo.server;

import com.demo.server.entity.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coffee/")
@Slf4j
public class Controller {
    @PostMapping("list")
    public List<Coffee> list() {
        List<Coffee> list = new ArrayList<>();
        Coffee coffee = new Coffee();
        coffee.setId("1");
        coffee.setName("moka");
        coffee.setPrice(BigDecimal.valueOf(25.00));
        list.add(coffee);
        coffee = new Coffee();
        coffee.setId("2");
        coffee.setName("nati");
        coffee.setPrice(BigDecimal.valueOf(30.00));
        list.add(coffee);
        return list;
    }

    @PostMapping("get")
    public Coffee get() {
        Coffee coffee = new Coffee();
        coffee.setId("1");
        coffee.setName("moka");
        coffee.setPrice(BigDecimal.valueOf(25.00));
        return coffee;
    }

    @PostMapping("add")
    public void add(@RequestBody Coffee coffee) {
        log.info("添加的coffee:{}", coffee);
    }
}
