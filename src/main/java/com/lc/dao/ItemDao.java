package com.lc.dao;

import com.lc.pojo.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item, Long> {

    void add(Item item);

    void delete(long id);

    void update(Item item);

    Item findAll(Item item);
}
