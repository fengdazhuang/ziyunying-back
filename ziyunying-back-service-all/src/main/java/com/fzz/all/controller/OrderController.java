package com.fzz.all.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fzz.all.service.OrderItemService;
import com.fzz.all.service.OrderService;
import com.fzz.api.BaseController;
import com.fzz.api.controller.all.OrderControllerApi;
import com.fzz.common.result.GraceJSONResult;
import com.fzz.pojo.Order;
import com.fzz.pojo.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController extends BaseController implements OrderControllerApi {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;

    @Override
    public GraceJSONResult getPage(Integer currentPage, Integer pageSize, Integer status, Long id) {
        if(id==null){
            return GraceJSONResult.errorMsg("没有用户id");
        }
        if(currentPage==null){
            currentPage=COMMON_START_PAGE;
        }
        if(pageSize==null){
            pageSize=COMMON_PAGE_SIZE;
        }
        Page<Order> pageInfo=new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Order> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Order::getUserId,id);
        if(status==1||status==2||status==3||status==4||status==5||status==6){
            queryWrapper.eq(Order::getOrderStatus,status);
        }
        orderService.page(pageInfo,queryWrapper);
        return GraceJSONResult.ok(pageInfo);
    }

    @Override
    public GraceJSONResult getDetail(Long id) {
        Order order = orderService.getById(id);
        return GraceJSONResult.ok(order);
    }

    @Override
    public GraceJSONResult getOrderItems(Long id) {
        LambdaQueryWrapper<OrderItem> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderItem::getOrderId,id);
        List<OrderItem> list = orderItemService.list(queryWrapper);
        return GraceJSONResult.ok(list);
    }
}
