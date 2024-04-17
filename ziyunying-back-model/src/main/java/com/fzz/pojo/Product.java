package com.fzz.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Product {
    @TableId
    private Long productId;

    private String name;

    /**
     * 类别
     */
    private String classification;

    private float price;

    /**
     * 规格
     */
    private String specifications;

    private Long publisherId;

    private String publisherName;

    /**
     * 销量
     */
    private Integer salesVolume;

    /**
     * 库存
     */
    private Integer inventory;

    private Integer status;

    private String img;

    private Integer commentCount;


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
}
