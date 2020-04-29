package cn.zhongguochu.demo.service.Impl;

import cn.zhongguochu.demo.entity.Folder;
import cn.zhongguochu.demo.entity.Photo;
import cn.zhongguochu.demo.mapper.FolderMapper;
import cn.zhongguochu.demo.mapper.PhotoMapper;
import cn.zhongguochu.demo.result.MyResult;
import cn.zhongguochu.demo.result.Result;
import cn.zhongguochu.demo.service.HelloService;
import cn.zhongguochu.demo.utils.UUId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private PhotoMapper photoMapper;
    @Autowired
    private FolderMapper folderMapper;

    /**
     * propagation的默认值为REQUIRED
     * REQUIRED  如果还没有事务，就创建一个新事务，如果事务已经存在，就使用已经存在的事务，所以默认情况，子方法和父方法会一起回滚
     * REQUIRES_NEW  每次都创建一个新事务，所以，父子回滚互不关联
     * NESTED  在子完成后，父发生异常，子会被回滚，但是在父完成数据库操作后，执行子发生异常，父不回滚
     * 常用前三个
     * NEVER  强制要求不在事务中运行，如果当前存在一个事务，则抛出异常
     * NOT_SUPPORTED  强制不在事务中运行，如果当前存在一个事务，则挂起该事务
     * SUPPORTS  支持当前事务，如果没有事务那么就不在事务中运行（SUPPORTS传播性的逻辑含义比较模糊，因此一般是不推荐使用的）
     * @return
     */
    // TODO 未验证
    @Transactional
    @Override
    public Result hello() {
        Photo photo = new Photo();
        photo.setId(UUId.getUUId());
        photo.setName("photo1");
        photo.setParentId("111");
        photo.setSort(1);
        photo.setUrl("www.baidu.com");
        photo.setRemarks("新增照片");
        photo.setCreateBy("admin");
        photo.setCreateDate(new Date());
        photoMapper.insert(photo);
        insertFolder();
        return MyResult.success();
    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public int insertFolder() {
        Folder folder = new Folder();
        folder.setId(UUId.getUUId());
        folder.setCoverUrl("www.baidu.com");
        folder.setName("folder1");
        folder.setSort(1);
        folder.setRemarks("新增文件夹");
        folder.setCreateBy("admin");
        folder.setCreateDate(new Date());
        int number = folderMapper.insert(folder);
        return number;
    }
}
