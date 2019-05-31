package com.xxx.xxx.service;

import com.xxx.xxx.entity.ItemCat;
import com.xxx.xxx.mapper.ItemCatMapper;
import com.xxx.xxx.utils.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Service
public class ItemCatService extends AbstractService<ItemCat> {

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public Mapper<ItemCat> getMapper() {
        return itemCatMapper;
    }
    
    public List<ItemCat> selectList(ItemCat itemCat) {
    	List<ItemCat> itemCatlist = itemCatMapper.selectList(itemCat);
		return itemCatlist;
	}
}
