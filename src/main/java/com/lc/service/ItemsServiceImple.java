package com.lc.service;

import com.lc.dao.ItemDao;
import com.lc.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemsServiceImple implements ItemsService {

    @Autowired
    private ItemDao itemDao;

    /**
     * 保存商品
     * @param item
     */
    @Override
    public void save(Item item) {
        this.itemDao.save(item);
    }

    /**
     * 根据条件查询
     * @param item
     * @return
     */

    @Override
    public List<Item> findAll(Item item) {
        //声明查询条件
        Example<Item> example = Example.of(item);

        List<Item> list = this.itemDao.findAll(example);
        return list;
    }
}
