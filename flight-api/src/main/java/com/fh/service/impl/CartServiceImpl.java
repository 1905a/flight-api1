package com.fh.service.impl;

import com.fh.code.ResponseEnum;
import com.fh.code.ServerResponse;
import com.fh.mapper.CartMapper;
import com.fh.model.OrderItem;
import com.fh.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public ServerResponse addMessage(OrderItem orderItem) {
        if(orderItem == null){
            return ServerResponse.error(ResponseEnum.orderItem_IS_NULL);
        }

        String cartKey = "flightTicket:" + orderItem.getUserId();
        String productKey = orderItem.getRealName();
        redisTemplate.opsForHash().put(cartKey,productKey,orderItem);

        List<OrderItem> cartItemList = redisTemplate.opsForHash().values(cartKey);

        int size = cartItemList.size();

        return ServerResponse.success(size);
    }
}
