package com.fh.controller;

import com.fh.code.ServerResponse;
import com.fh.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("LoginController")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @RequestMapping("login")
    public ServerResponse login(String loginName, String password) {

        ServerResponse serverResponse = loginService.selectUserByUsername(loginName, password);

        return serverResponse;
    }





}
