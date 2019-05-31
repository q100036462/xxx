package com.xxx.xxx.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxx.xxx.entity.Cgoods;
import com.xxx.xxx.mapper.CgoodsMapper;
import com.xxx.xxx.utils.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Service
public class CgoodsService extends AbstractService<Cgoods> {

    @Autowired
    private CgoodsMapper cgoodsMapper;

    @Override
    public Mapper<Cgoods> getMapper() {
        return cgoodsMapper;
    }

    
    public PageInfo<Cgoods> findAllcgoods(Cgoods cgoods, int page, int size){
        PageHelper.startPage(page,size);
        List<Cgoods> cgoodsList = cgoodsMapper.selectByExample(cgoods);
        PageInfo<Cgoods> pageInfo = new PageInfo<Cgoods>(cgoodsList);
        return pageInfo;
    }
    
    public List<Cgoods> selectList(Cgoods cgoods) {
    	List<Cgoods> cgoodslist = cgoodsMapper.selectList(cgoods);
		return cgoodslist;
	}
}
