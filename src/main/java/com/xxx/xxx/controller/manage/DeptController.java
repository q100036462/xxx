package com.xxx.xxx.controller.manage;

import com.github.pagehelper.PageInfo;
import com.xxx.xxx.entity.Dept;
import com.xxx.xxx.entity.User;
import com.xxx.xxx.service.DeptService;
import com.xxx.xxx.service.UserService;
import com.xxx.xxx.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;
    @Autowired
    private UserService userService;

    @RequestMapping("toDeptPage")
    public String toDeptPage(){
        return "page/dept/dept_list";
    }

    @RequestMapping("deptList")
    @ResponseBody
    public Map<String, Object> findAll(Dept dept, Integer page, Integer limit){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        PageInfo<Dept> pager = deptService.findAllDept(dept,page,limit);
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        //总条数
        resultMap.put("count", pager.getTotal());
        //获取每页数据
        resultMap.put("data", pager.getList());
        return resultMap;
    }

    @RequestMapping("/updateDeptTypeById")
    @ResponseBody
    public String updateDeptTypeById(Dept dept){
        dept.setUpdateby(UserUtils.getUser().getId());
        dept.setUpdatetime(new Date());
        int i = deptService.getMapper().updateByPrimaryKeySelective(dept);
        if (i>=1){
            return dept.getType().toString();
        }
        return "error";
    }

    @RequestMapping("toDeptAdd")
    public String toDeptAdd(Model model){
        List<User> admins = userService.findAllAdmin();
        model.addAttribute("admins",admins);
        return "page/dept/dept_add";
    }

    @RequestMapping("toDeptEdit")
    public String toDeptEdit(Dept dept,Model model){
        Dept dept1 = deptService.getMapper().selectOne(dept);
        List<User> admins = userService.findAllAdmin();
        model.addAttribute("admins",admins);
        model.addAttribute("dept",dept1);
        return "page/dept/dept_edit";
    }

    @RequestMapping("/updateDeptById")
    @ResponseBody
    public String updateDeptById(Dept dept){
        dept.setUpdateby(UserUtils.getUser().getId());
        dept.setUpdatetime(new Date());
        int i = deptService.getMapper().updateByPrimaryKeySelective(dept);
        if (i>=1){
            return "success";
        }
        return "error";
    }

}
