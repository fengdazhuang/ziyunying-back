package com.fzz.api.controller.all;

import com.fzz.bo.AddressForm;
import com.fzz.common.result.GraceJSONResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/user")
public interface UserControllerApi {

    @GetMapping("/login")
    public GraceJSONResult loginOrRegister(@RequestParam String phone,
                                 @RequestParam String password,
                                 @RequestParam String validCode,
                                 @RequestParam boolean rememberPwd
    );




    @GetMapping("/logout")
    public GraceJSONResult logout();

    @GetMapping("/getUserInfo")
    public GraceJSONResult getUserInfo(@RequestParam Long id);


    @GetMapping("/getDetaAddr")
    public GraceJSONResult getDetaAddr(@RequestParam Long id);

    @GetMapping("/getAddressList")
    public GraceJSONResult getAddressList(@RequestParam Long id);

    @PostMapping("/addAddress")
    public GraceJSONResult addAddress(@RequestBody AddressForm addressForm);





    @PostMapping
    public GraceJSONResult updatePassword();

}
