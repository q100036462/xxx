package com.xxx.xxx.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xxx.xxx.entity.ItemCat;

import tk.mybatis.mapper.common.Mapper;


@Repository
public interface ItemCatMapper extends Mapper<ItemCat> {
	public List<ItemCat> selectList(ItemCat itemCat);
    
}
