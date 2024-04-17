package com.fzz.pojo;

import com.baomidou.mybatisplus.annotation.*;
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
    private Date createdTime;

    /**
     * 更新时间 更新时间
     */
    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Date updatedTime;

//    private Date delivery_time;

    private Date finishTime;

    private Date cancelTime;

    private Integer closeType;

    private Date payTime;

}
