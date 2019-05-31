package com.xxx.xxx.controller.manage;

import com.github.pagehelper.PageInfo;
import com.xxx.xxx.entity.Leavel;
import com.xxx.xxx.entity.LeavelDTO;
import com.xxx.xxx.service.LeaveService;
import com.xxx.xxx.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @RequestMapping("toLeaveList")
    public String toLeaveList(){
        return "page/leave/leave_list";
    }

    @RequestMapping("leaveList")
    @ResponseBody
    public Map<String, Object> leaveList(Leavel leavel, Integer page, Integer limit){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        PageInfo<LeavelDTO> pager = leaveService.selectAllLeave(leavel, page, limit);
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        //总条数
        resultMap.put("count", pager.getTotal());
        //获取每页数据
        resultMap.put("data", pager.getList());
        return resultMap;
    }

    @RequestMapping("/updateLeaveTypeById")
    @ResponseBody
    public String updateLeaveTypeById(Leavel leavel){
        leavel.setUpdateby(UserUtils.getUser().getId());
        leavel.setUpdatetime(new Date());
        int i = leaveService.getMapper().updateByPrimaryKeySelective(leavel);
        if (i >= 1){
            return leavel.getType().toString();
        }
        return "error";
    }
}
