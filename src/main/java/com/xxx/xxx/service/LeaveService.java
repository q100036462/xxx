package com.xxx.xxx.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxx.xxx.entity.Leavel;
import com.xxx.xxx.entity.LeavelDTO;
import com.xxx.xxx.mapper.LeaveMapper;
import com.xxx.xxx.utils.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Service
public class LeaveService extends AbstractService<Leavel> {
    @Autowired
    private LeaveMapper leaveMapper;

    @Override
    public Mapper<Leavel> getMapper() {
        return leaveMapper;
    }

    public PageInfo<LeavelDTO> selectAllLeave(Leavel leavel, Integer page, Integer pageSize){
        PageHelper.startPage(page,pageSize);
        List<LeavelDTO> Leaves = leaveMapper.selectAllLeave();
        PageInfo<LeavelDTO> pageInfo = new PageInfo<LeavelDTO>(Leaves);
        return pageInfo;
    }
}
