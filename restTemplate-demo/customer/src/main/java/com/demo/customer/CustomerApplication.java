package com.demo.customer;

import com.demo.customer.entity.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
@Slf4j
public class CustomerApplication implements ApplicationRunner {
	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(CustomerApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.web(WebApplicationType.NONE)
				.run(args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// 返回是基本类型或者单对象，则直接可以使用getForObject等简单的方法，并指定返回类型即可
		Coffee coffee = restTemplate.postForObject("http://localhost:8080/coffee/get", null, Coffee.class);
		log.info("getCoffee:{}", coffee);

		// 如果是List这样的，则需要用到泛型ParameterizedTypeReference定义返回值，并且需要使用exchange方法去请求。
		// 依然使用List.class去作为返回值的话，list里面的值是LinkedHashMap对象，不是你期望的Coffee对象，因而会有问题
		ParameterizedTypeReference<List<Coffee>> refc = new ParameterizedTypeReference<List<Coffee>>() {};
		ResponseEntity<List<Coffee>> exchange = restTemplate.exchange("http://localhost:8080/coffee/list", HttpMethod.POST, null, refc);
		List<Coffee> list = exchange.getBody();
		log.info("list:{}", list);
		list.forEach(item -> log.info("coffee:{}", item));

		// 保存调用，request参数传入coffee1
		Coffee coffee1 = new Coffee();
		coffee1.setId("1");
		coffee1.setName("maoshi");
		coffee1.setPrice(BigDecimal.valueOf(50.00));
		restTemplate.postForObject("http://localhost:8080/coffee/add", coffee1, Void.class);
	}
}
