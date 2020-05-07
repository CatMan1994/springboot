package cn.zhongguochu.demo.entity;

import java.io.Serializable;

public class Test implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    public Test() {
        super();
    }

    public Test(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}