package com.xxx.xxx.mapper;

import com.xxx.xxx.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserMapper extends Mapper<User> {

    List<User> findAllUser(User user);

    int findMaxId();

    List<String> selectRolesByUsername(String username);

    List<User> findAllAdmin();
}
