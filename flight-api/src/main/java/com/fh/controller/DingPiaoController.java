package com.fh.controller;

import com.fh.code.ServerResponse;
import com.fh.model.Flight;
import com.fh.model.PlaneType;
import com.fh.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("DingPiaoController")
public class DingPiaoController {

    @Autowired
    private FlightService flightService;


    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("dingpiao")
    public ServerResponse selectFlightById(String id){
        Flight flight = flightService.selectFlightById(Integer.parseInt(id));

        String cartKey = "flight:" + id;
        String productKey = id + "";
        redisTemplate.opsForHash().put(cartKey,productKey,flight);
        return ServerResponse.success(flight);
    }

    @RequestMapping("getPiao")
    public ServerResponse selectFlightById(Integer id){
        String cartKey = "flight:" + id;
        String productKey = id + "";
        Flight flight = (Flight) redisTemplate.opsForHash().get(cartKey, productKey);
        return ServerResponse.success(flight);
    }



}
