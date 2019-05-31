package com.xxx.xxx.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxx.xxx.entity.Dept;
import com.xxx.xxx.mapper.DeptMapper;
import com.xxx.xxx.utils.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Service
public class DeptService extends AbstractService<Dept> {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Mapper<Dept> getMapper() {
        return deptMapper;
    }

    public PageInfo<Dept> findAllDept(Dept dept, Integer page, Integer pageSize){
        PageHelper.startPage(page,pageSize);
        List<Dept> depts = deptMapper.findAllDept(dept);
        PageInfo<Dept> pageInfo = new PageInfo<Dept>(depts);
        return pageInfo;
    }
}
