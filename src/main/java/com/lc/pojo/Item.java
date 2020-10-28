package com.lc.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.persistence.Table;
import java.util.Date;

@Table(name = "jd_items")
@Component("item")
@Data
public class Item {
    @Id
    private long id;

    private long spu;

    private long sku;

    private String title;

    private Double price;

    private String pic;

    private String url;

    private Date createdtime;

    private Date updatetime;
}
