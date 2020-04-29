package cn.zhongguochu.demo.utils;

import java.util.UUID;

public class UUId {
    public static String getUUId() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
