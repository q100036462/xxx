package com.xxx.xxx.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xxx.xxx.entity.Cgoods;

import tk.mybatis.mapper.common.Mapper;


@Repository
public interface CgoodsMapper extends Mapper<Cgoods> {
	public List<Cgoods> selectList(Cgoods cgoods);
    
}
