package com.fzz.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class AppUser {

    private Long id;

    /**
     * 手机号
     */
    private String phone;

    private String password;

    /**
     * 昵称，媒体号
     */
    private String username;

    /**
     * 邮箱地址
     */
    private String email;

    private String img;

    /**
     * 性别 1:男  0:女  2:保密
     */
    private Integer sex;

    /**
     * 生日
     */
    private Date birthday;

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