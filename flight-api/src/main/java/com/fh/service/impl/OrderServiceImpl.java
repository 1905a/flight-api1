package com.fh.service.impl;

import com.fh.code.ResponseEnum;
import com.fh.code.ServerResponse;
import com.fh.mapper.FlightTicketMapper;
import com.fh.mapper.OrderMapper;
import com.fh.model.Order;
import com.fh.model.OrderItem;
import com.fh.model.PayLog;
import com.fh.service.OrderService;
import com.fh.service.PayLogService;
import com.fh.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;


    @Autowired
    private FlightTicketMapper flightTicketMapper;

    @Autowired
    private RedisTemplate redisTemplate;


    @Autowired
    private PayLogService payLogService;

    @Override
    public ServerResponse addOrder(Integer id) {

        String cartKey = "flight:" + id;
        if(!redisTemplate.hasKey(cartKey)){
            return ServerResponse.error(ResponseEnum.CART_IS_NOT_EXISTED);
        }
        //将用户购物车中的所有商品取出来
        List<OrderItem> orderItems = redisTemplate.opsForHash().values(cartKey);

        //时间戳+雪花生成Id
        String orderId = IdUtil.createId();

        //用于统计减库存成功的商品的总金额
        BigDecimal totalPrice = new BigDecimal("0");

        //订单明细的集合
        List<OrderItem> orderItemList = new ArrayList<>();

        for (OrderItem cartItem : orderItems) {

            //减库存
            Long rowsCount = flightTicketMapper.updateProduct(cartItem.getTicketId());
            if(rowsCount>0){


                //创建订单详情
                OrderItem orderItem = new OrderItem();

                orderItem.setOrderId(orderId);
                orderItem.setPrice(cartItem.getPrice());
                orderItem.setUserId(id);
                orderItem.setRealName(cartItem.getRealName());
                orderItem.setIdCard(cartItem.getIdCard());
                orderItemList.add(orderItem);
                totalPrice = totalPrice.add(cartItem.getPrice());

            }
        }


        //创建订单
        Order order = new Order();
        order.setId(orderId);
        order.setUserId(id);
        order.setCreateTime(new Date());
        order.setTotalPrice(totalPrice);
        order.setPayType(1); //1代表在线支付 2代表货到付款
        order.setStatus(1); //1代表未付款 2代表已支付
        orderMapper.addOrder(order);

        //创建订单明细
        orderMapper.addOrderItemList(orderItemList);

        //生成支付日志
        //支付日志表:用来记录用户的支付行为，比如说支付订单号，订单号，微信支付订单号，支付了多少钱，谁支付的，什么时候支付的，支付的方式，支付的状态(1代表未支付，2代表已支付)
        PayLog payLog = new PayLog();


        payLog.setOuttradeno(IdUtil.createId());
        payLog.setPaystatus(1);
        payLog.setUserid(id);
        payLog.setPaytype(1);
        payLog.setPaymoney(totalPrice);
        payLog.setTransactionid(orderId);

        //将支付日志保存到支付日志表中
        payLogService.addPayLog(payLog);

        //将支付日志保存到redis中，方便在支付页面取出支付日志
        redisTemplate.opsForValue().set("payLog:" + id,payLog);

        //将下单成功的商品从用户的购物车中删除掉
        for (OrderItem orderItem : orderItemList) {
            redisTemplate.opsForHash().delete(cartKey,orderItem.getRealName());
        }


        return null;
    }
}
