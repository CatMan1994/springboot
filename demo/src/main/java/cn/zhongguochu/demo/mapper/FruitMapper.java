package cn.zhongguochu.demo.mapper;

import cn.zhongguochu.demo.entity.Fruit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FruitMapper {
    int insert(Fruit fruit);
    Fruit get(@Param("id") String id);
}
