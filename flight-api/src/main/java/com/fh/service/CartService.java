package com.fh.service;

import com.fh.code.ServerResponse;
import com.fh.model.OrderItem;

public interface CartService {


    ServerResponse addMessage(OrderItem orderItem);
}
