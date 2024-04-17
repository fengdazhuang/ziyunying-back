package com.fzz.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("Orders")
public class Order {

    @TableId
    private Long orderId;

    private Long userId;

    private String productName;

    private Long payId;

//    private String receiverName;
//
//    private String receiverMobile;

    private Long addressId;

    private float totalPrice;

    private Integer payType;

    private String orderRemark;

    private Integer orderStatus;

//    private Integer deliveryType;
//
//    private String deliveryFlowId;

    @TableLogic
    private Integer isDeleted;

    /**
     * 创建时间 创建时间
     */
    @TableField(fill= FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;

    /**
     * 更新时间 更新时间
     */
    @TableField(fill=FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedTime;

//    private Date delivery_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date finishTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date cancelTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Integer closeType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date payTime;

}
