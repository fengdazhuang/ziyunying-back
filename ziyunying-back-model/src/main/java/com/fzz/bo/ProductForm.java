package com.fzz.bo;

import lombok.Data;


@Data
public class ProductForm {

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

    private String img;

    /**
     * 库存
     */
    private Integer inventory;


}
