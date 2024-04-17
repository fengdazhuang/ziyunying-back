package com.fzz.bo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class AddressForm {


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
    private Date createdTime;

    /**
     * 更新时间 更新时间
     */
    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Date updatedTime;




}
