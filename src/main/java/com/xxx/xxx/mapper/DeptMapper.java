package com.xxx.xxx.mapper;

import com.xxx.xxx.entity.Dept;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface DeptMapper extends Mapper<Dept> {

    public List<Dept> findAllDept(Dept dept);
}
