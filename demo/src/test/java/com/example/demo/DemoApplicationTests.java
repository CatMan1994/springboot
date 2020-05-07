package com.example.demo;

import cn.zhongguochu.demo.DemoApplication;
import cn.zhongguochu.demo.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {
	@Autowired
	private TestService testService;

	@Test
	void contextLoads() {
	}

}
