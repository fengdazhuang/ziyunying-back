package com.fzz.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class MyCollections {

    @TableId
    private Long id;

    private Long productId;

    private Long userId;

    private String productName;

    private String productPrice;

    private String productImg;
}
