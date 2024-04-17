package com.fzz.all.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fzz.all.mapper.OrderMapper;
import com.fzz.all.service.OrderService;
import com.fzz.pojo.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
