package cn.zhongguochu.demo.service.Impl;

import cn.zhongguochu.demo.entity.Test;
import cn.zhongguochu.demo.mapper.TestMapper;
import cn.zhongguochu.demo.result.MyResult;
import cn.zhongguochu.demo.result.Result;
import cn.zhongguochu.demo.service.TestService;
import cn.zhongguochu.demo.utils.UUId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public int testB() {
        testMapper.insert(new Test("testB"));
        throw new RuntimeException();
    }
}
