package com.xxx.xxx.service;

import com.xxx.xxx.entity.Role;
import com.xxx.xxx.mapper.RoleMapper;
import com.xxx.xxx.utils.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public class RoleService extends AbstractService<Role> {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Mapper<Role> getMapper() {
        return roleMapper;
    }
}
