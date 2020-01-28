package com.fh.mapper;


import com.fh.model.User;

public interface LoginMapper {

    User selectUserByUsername(String loginName);


}
