package com.lc.dao;

import com.lc.pojo.Item;

public interface ItemDao {

    void add();

    void delete(long id);

    void update();

    Item selectByid(long id);
}
