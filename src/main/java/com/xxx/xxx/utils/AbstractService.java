package com.xxx.xxx.utils;

import tk.mybatis.mapper.common.Mapper;


public abstract class AbstractService<T> {

    public abstract Mapper<T> getMapper();
}
