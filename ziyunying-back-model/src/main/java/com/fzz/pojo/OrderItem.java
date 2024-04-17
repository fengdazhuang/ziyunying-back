package com.fzz.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class OrderItem {

    @TableId
    private Long itemId;

    private Long orderId;

    private Long productId;

    private String productName;

    private String productImg;

    private float productPrice;

    private Integer buyCounts;

    private float totalAmount;

    private Date basketDate;

    private Date buyTime;

    private Integer isComment;



}
