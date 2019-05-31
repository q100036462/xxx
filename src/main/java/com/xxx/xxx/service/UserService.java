package com.xxx.xxx.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxx.xxx.entity.User;
import com.xxx.xxx.mapper.UserMapper;
import com.xxx.xxx.utils.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Service
public class UserService extends AbstractService<User> {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Mapper<User> getMapper() {
        return userMapper;
    }

    /**
     * 查询所有的员工（分页）
     * @param user 查询条件
     * @param page 页数
     * @param size 每页大小
     * @return
     */
    public PageInfo<User> findAllUser(User user, int page, int size){
        PageHelper.startPage(page,size);
        List<User> users = userMapper.findAllUser(user);
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return pageInfo;
    }

    /**
     * 查询user表最大ID
     * @return
     */
    public int findMaxId(){
        return userMapper.findMaxId();
    }

    /**
     * 查询所有的工地管理员
     * @return
     */
    public List<User> findAllAdmin(){
        return userMapper.findAllAdmin();
    }
}
