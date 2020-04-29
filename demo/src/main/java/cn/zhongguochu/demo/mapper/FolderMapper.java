package cn.zhongguochu.demo.mapper;

import cn.zhongguochu.demo.entity.Folder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FolderMapper {
    int insert(Folder folder);
}
