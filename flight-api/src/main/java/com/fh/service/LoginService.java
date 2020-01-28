package com.fh.service;

import com.fh.code.ServerResponse;

public interface LoginService {

    ServerResponse selectUserByUsername(String loginName, String password);

}
