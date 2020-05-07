package cn.zhongguochu.demo.entity;

import java.io.Serializable;
import org.joda.money.Money;

public class Fruit implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private Money price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }
}