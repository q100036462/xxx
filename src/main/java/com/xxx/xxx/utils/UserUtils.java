package com.xxx.xxx.utils;

import com.xxx.xxx.entity.User;
import org.apache.shiro.SecurityUtils;

public class UserUtils {

    public static User getUser(){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        return user;
    }
}
