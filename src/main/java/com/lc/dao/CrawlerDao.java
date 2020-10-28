package com.lc.dao;


import com.lc.pojo.Item;

public interface CrawlerDao {

    void add();

    void delete(long id);

    void update();

    Item selectByid(long id);
}
