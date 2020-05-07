package cn.zhongguochu.demo.service.Impl;

import cn.zhongguochu.demo.entity.Fruit;
import cn.zhongguochu.demo.entity.Test;
import cn.zhongguochu.demo.mapper.FruitMapper;
import cn.zhongguochu.demo.mapper.TestMapper;
import cn.zhongguochu.demo.result.MyResult;
import cn.zhongguochu.demo.result.Result;
import cn.zhongguochu.demo.service.Test1Service;
import cn.zhongguochu.demo.service.TestService;
import cn.zhongguochu.demo.utils.UUId;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Test1ServiceImpl implements Test1Service {
    @Autowired
    private TestService testService;
    @Autowired
    private TestMapper testMapper;

    @Autowired
    private FruitMapper fruitMapper;

    @Override
    @Transactional
    public Result testA() {
//        Fruit fruit = new Fruit();
//        fruit.setId(UUId.getUUId());
//        fruit.setName("苹果");
//        fruit.setPrice(Money.of(CurrencyUnit.of("CNY"), 5.8));
//        fruitMapper.insert(fruit);
//        testMapper.insert(new Test("testA"));
//        testService.testB();
        Fruit fruit = fruitMapper.get("da0ee8f6525f4ead86f86c2aef306c3c");
        return MyResult.success(fruit);
    }
}
