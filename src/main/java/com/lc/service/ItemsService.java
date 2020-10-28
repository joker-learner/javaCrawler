package com.lc.service;

import com.lc.pojo.Item;

import java.util.List;

public interface ItemsService {
    /**
     * c查询商品
     */
    void add(Item item);
    /**
     * 根据条件查询商品
     */
    List<Item> query(Item item);

}
