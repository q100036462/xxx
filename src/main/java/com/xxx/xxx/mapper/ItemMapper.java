package com.xxx.xxx.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xxx.xxx.entity.Item;

import tk.mybatis.mapper.common.Mapper;


@Repository
public interface ItemMapper extends Mapper<Item> {
	public List<Item> selectList(Item item);
    
}
