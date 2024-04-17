package com.fzz.all.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fzz.all.mapper.OrderItemMapper;
import com.fzz.all.mapper.OrderMapper;
import com.fzz.all.service.OrderItemService;
import com.fzz.all.service.OrderService;
import com.fzz.pojo.Order;
import com.fzz.pojo.OrderItem;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}
