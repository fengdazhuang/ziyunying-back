package com.fzz.api.controller.all;

import com.fzz.common.result.GraceJSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/order")
public interface OrderControllerApi {
    @GetMapping("/getPage")
    public GraceJSONResult getPage(@RequestParam Integer currentPage,
                                   @RequestParam Integer pageSize,
                                   @RequestParam Integer status,
                                   @RequestParam Long id);

    @GetMapping("/getDetail")
    public GraceJSONResult getDetail(@RequestParam Long id);

    @GetMapping("/getOrderItems")
    public GraceJSONResult getOrderItems(@RequestParam Long id);

}
