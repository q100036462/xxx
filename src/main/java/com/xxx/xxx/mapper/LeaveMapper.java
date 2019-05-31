package com.xxx.xxx.mapper;

import com.xxx.xxx.entity.Leavel;
import com.xxx.xxx.entity.LeavelDTO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface LeaveMapper extends Mapper<Leavel> {

    public List<LeavelDTO> selectAllLeave();
}
