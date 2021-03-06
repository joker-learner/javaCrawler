package com.lc.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "jd_items")
//@Component("item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long spu;

    private Long sku;

    private String title;

    private Double price;

    private String pic;

    private String url;

    private Date createdtime;

    private Date updatetime;

}
