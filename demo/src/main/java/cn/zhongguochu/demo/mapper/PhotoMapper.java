package cn.zhongguochu.demo.mapper;

import cn.zhongguochu.demo.entity.Photo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PhotoMapper {
    int insert(Photo photo);
}
