package com.fh.controller;

import com.fh.code.ServerResponse;
import com.fh.model.Flight;
import com.fh.model.OrderItem;
import com.fh.model.User;
import com.fh.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("CartController")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("addMessage")
    public ServerResponse addMessage(OrderItem orderItem, HttpServletRequest request){

        User loginUser = (User) request.getAttribute("loginUser");

        orderItem.setUserId(loginUser.getId());

        ServerResponse serverResponse =  cartService.addMessage(orderItem);

        return serverResponse;
    }

}
