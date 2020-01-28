package com.fh.interceptor;

import com.alibaba.fastjson.JSONObject;

import com.fh.code.ResponseEnum;
import com.fh.code.ServerResponse;
import com.fh.model.User;
import com.fh.util.JsonUtil;
import com.fh.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("abc");
        if (StringUtils.isBlank(token)) {
            JsonUtil.outJson(response, ServerResponse.error(ResponseEnum.TOKEN_IS_NULL));
            return false;
        }

        String[] tokenArr = token.split("\\.");
        if (tokenArr.length != 3) {
            JsonUtil.outJson(response, ServerResponse.error(ResponseEnum.TOKEN_IS_ERROR));
            return false;
        }

        String loginUserJson = null;
        try {
            loginUserJson = JwtUtil.verifyToken(token);
        } catch (Exception e) {
            JsonUtil.outJson(response, ServerResponse.error(ResponseEnum.TOKEN_VERIFY_ERROR));
            return false;
        }

        User shopUser = JSONObject.parseObject(loginUserJson, User.class);

        if (!redisTemplate.hasKey("loginUser:" + shopUser.getUUID())) {
            JsonUtil.outJson(response, ServerResponse.error(ResponseEnum.TOKEN_IS_EXPIRED));
            return false;
        }

        redisTemplate.expire("loginUser:" + shopUser.getUUID(), 30, TimeUnit.MINUTES);

        request.setAttribute("loginUser", shopUser);

        return true;
    }

}
