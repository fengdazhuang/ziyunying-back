package com.fzz.all.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fzz.pojo.Order;
import com.fzz.pojo.OrderItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {
}
