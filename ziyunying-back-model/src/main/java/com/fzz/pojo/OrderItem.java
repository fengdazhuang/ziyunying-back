package com.fzz.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date basketDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date buyTime;

    private Integer isComment;



}
