package com.example.mybatis.mapper;

import com.example.mybatis.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getOne();
}
