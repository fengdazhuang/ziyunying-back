package com.fzz.all.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fzz.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
