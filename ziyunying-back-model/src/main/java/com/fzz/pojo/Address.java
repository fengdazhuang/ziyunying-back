package com.fzz.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Address {

    @TableId
    private Long addressId;

    private Long userId;

    private String province;

    private String city;

    private String county;

    private String detailedAddr;

    private String receiverName;

    private String receiverPhone;

    /**
     * 创建时间 创建时间
     */
    @TableField(fill= FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;

    /**
     * 更新时间 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Date updatedTime;




}
