package com.fh.controller;

import com.fh.code.ServerResponse;
import com.fh.model.User;
import com.fh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("OrderController")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //提交订单 OrderController/submitOrder
    @RequestMapping("submitOrder")
    public ServerResponse addOrder(HttpServletRequest request){
        try {
            User loginMember = (User) request.getAttribute("loginUser");
            ServerResponse serverResponse = orderService.addOrder(loginMember.getId());
            return serverResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.error();
        }
    }

}
