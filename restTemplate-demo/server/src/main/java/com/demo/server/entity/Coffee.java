package com.demo.server.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class Coffee implements Serializable {
    private static final long serialVersionUID = -3101563579631083086L;
    private String id;

    private String name;

    private BigDecimal price;

    private Date createTime;

    private Date updateTime;
}
