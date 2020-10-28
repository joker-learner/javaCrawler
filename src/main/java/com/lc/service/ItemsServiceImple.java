package com.lc.service;

import com.lc.dao.ItemDao;
import com.lc.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemsServiceImple implements ItemsService{

    @Autowired
    private ItemDao itemDao;
    @Override
    public void add(Item item) {
        itemDao.add(item);
    }

    @Override
    public List<Item> query(Item item) {
        return null;
    }
}
