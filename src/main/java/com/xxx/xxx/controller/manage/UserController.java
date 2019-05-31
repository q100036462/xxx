package com.xxx.xxx.controller.manage;

import com.github.pagehelper.PageInfo;
import com.xxx.xxx.entity.Dept;
import com.xxx.xxx.entity.Role;
import com.xxx.xxx.entity.User;
import com.xxx.xxx.service.DeptService;
import com.xxx.xxx.service.RoleService;
import com.xxx.xxx.service.UserService;
import com.xxx.xxx.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private RoleService roleService;

    @ModelAttribute
    public void get(Model model){
        List<Dept> depts = deptService.getMapper().selectAll();
        model.addAttribute("depts",depts);
        List<Role> roles = roleService.getMapper().selectAll();
        model.addAttribute("roles",roles);
    }

    /**
     * 页面跳转
     * @return
     */
    @RequestMapping("/user")
    public String toUserlistPage(){

        return "page/user/user_list";
    }

    /**
     * 查找所有用户
     * @param page 页码
     * @param limit 每页条数
     * @return
     */
    @RequestMapping("/userList")
    @ResponseBody
    public Map<String, Object> findAll(User user, Integer page, Integer limit){
        //获取当前登录用户的信息
        User admin = UserUtils.getUser();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        PageInfo<User> pager = new PageInfo<>();
        if (admin.getRoleId() == 1){
            pager = userService.findAllUser(user,page, limit);
        }else if (admin.getRoleId() == 2){
            user.setDeptId(admin.getDeptId());
            pager = userService.findAllUser(user,page, limit);
        }
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        //总条数
        resultMap.put("count", pager.getTotal());
        //获取每页数据
        resultMap.put("data", pager.getList());
        return resultMap;
    }

    /**
     * 跳转到用户修改页面，并携带用户所有信息
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/toUserEdit")
    public String toUserEdit(User user, Model model){
        User user1 = userService.getMapper().selectByPrimaryKey(user.getId());
        user1.setPassword(null);
        model.addAttribute("user",user1);
        /*List<Dept> depts = deptService.getMapper().selectAll();
        model.addAttribute("depts",depts);*/
        return "page/user/user_edit";
    }

    /**
     * 根据ID修改用户信息
     * @param user
     * @return
     */
    @RequestMapping("/updateUserById")
    @ResponseBody
    public String updateUserById(User user){
        user.setUpdateby(UserUtils.getUser().getId());
        user.setUpdatetime(new Date());
        int i = userService.getMapper().updateByPrimaryKeySelective(user);
        if (i >= 1){
            return "success";
        }
        return "error";
    }

    /**
     * 跳转到添加用户页面
     * @param model
     * @return
     */
    @RequestMapping("/toUserAdd")
    public String toUserAdd(Model model){
        /*List<Dept> depts = deptService.getMapper().selectAll();
        model.addAttribute("depts",depts);*/
        return "page/user/user_add";
    }

    /**
     * 添加用户操作
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(User user){
        int maxId = userService.findMaxId()+1;
        DecimalFormat mFormat = new DecimalFormat("000");//确定格式，把1转换为001
        String username = user.getIdcard().substring(user.getIdcard().length() - 4)+ mFormat.format(maxId);
        user.setUsername(username);
        user.setCreateby(UserUtils.getUser().getId());
        user.setCreatetime(new Date());
        int i = userService.getMapper().insert(user);
        if (i>=1){
            return "success";
        }
        return "error";
    }

    /**
     * 更改用户状态
     * @param user
     * @return
     */
    @RequestMapping("/updateUserTypeById")
    @ResponseBody
    public String updateUserTypeById(User user){
        user.setUpdateby(UserUtils.getUser().getId());
        user.setUpdatetime(new Date());
        int i = userService.getMapper().updateByPrimaryKeySelective(user);
        if (i>=1){
            return user.getType().toString();
        }
        return "error";
    }

    /**
     * 跳转到修改密码页面
     * @param user
     * @return
     */
    @RequestMapping("/toUserPassword")
    public String toUserPassword(User user,Model model){
        model.addAttribute("user",user);
        return "page/user/user_password";
    }

    /**
     * 更改用户状态
     * @param user
     * @return
     */
    @RequestMapping("/updatePasswordById")
    @ResponseBody
    public String updatePasswordById(User user){
        user.setUpdateby(UserUtils.getUser().getId());
        user.setUpdatetime(new Date());
        int i = userService.getMapper().updateByPrimaryKeySelective(user);
        if (i >= 1){
            return "success";
        }
        return "error";
    }

    /**
     * 删除用户（逻辑删除）
     * @param user
     * @return
     */
    @RequestMapping("/delUser")
    @ResponseBody
    public String delUser(User user){
        user.setUpdateby(UserUtils.getUser().getId());
        user.setUpdatetime(new Date());
        user.setDelFlag(1);
        int i = userService.getMapper().updateByPrimaryKeySelective(user);
        if (i >= 1){
            return "success";
        }
        return "error";
    }
}
