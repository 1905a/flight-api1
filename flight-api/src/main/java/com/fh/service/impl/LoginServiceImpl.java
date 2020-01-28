package com.fh.service.impl;

import com.fh.mapper.LoginMapper;
import com.fh.code.ResponseEnum;
import com.fh.code.ServerResponse;
import com.fh.model.User;
import com.fh.service.LoginService;
import com.fh.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private LoginMapper loginMapper;


    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public ServerResponse selectUserByUsername(String loginName, String password) {

        if (StringUtils.isBlank(loginName)) {
            return ServerResponse.error(ResponseEnum.USER_IS_NULL);
        }

        if (StringUtils.isBlank(password)) {
            return ServerResponse.error(ResponseEnum.PASSWORD_IS_NULL);
        }

        User shopUser = loginMapper.selectUserByUsername(loginName);
        if (shopUser == null) {
            return ServerResponse.error(ResponseEnum.USER_IS_NOT_EXIST);
        }

        if (!shopUser.getPassword().equals(password)) {
            return ServerResponse.error(ResponseEnum.PASSWORD_ERROR);
        }

        User loginUser = new User();
        loginUser.setUUID(UUID.randomUUID() + toString());
        loginUser.setId(shopUser.getId());
        loginUser.setUsername(shopUser.getUsername());

        String token = JwtUtil.createToken(loginUser);

        redisTemplate.opsForValue().set("loginUser:" + loginUser.getUUID(), "145312", 30, TimeUnit.MINUTES);

        return ServerResponse.success(token);
    }


}
