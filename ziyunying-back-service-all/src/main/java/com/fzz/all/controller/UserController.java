package com.fzz.all.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fzz.all.service.AddressService;
import com.fzz.all.service.AppUserService;
import com.fzz.api.controller.all.UserControllerApi;
import com.fzz.bo.AddressForm;
import com.fzz.common.result.GraceJSONResult;
import com.fzz.pojo.Address;
import com.fzz.pojo.AppUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserControllerApi {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private AddressService addressService;


    @Override
    public GraceJSONResult loginOrRegister(String phone, String password,
                                           String validCode, boolean rememberPwd) {
        //登录
        if(StringUtils.isBlank(validCode)){
            //是否存在该用户
            AppUser appUser=appUserService.isExists(phone);
            if(appUser==null){
                return GraceJSONResult.errorMsg("该用户不存在");
            }
            if(password.equals(appUser.getPassword())){
                return GraceJSONResult.ok(appUser);
            }
            return GraceJSONResult.errorMsg("账号或密码不正确");
        }
        AppUser appUser=new AppUser();
        appUser.setPhone(phone);
        appUser.setPassword(password);
        boolean res = appUserService.saveNewUser(appUser);
        if(res){
            return GraceJSONResult.ok(appUser);
        }
        return GraceJSONResult.error();
    }

    @Override
    public GraceJSONResult logout() {
        return null;
    }

    @Override
    public GraceJSONResult getUserInfo(Long id) {
        AppUser user = appUserService.getById(id);
        return GraceJSONResult.ok(user);
    }

    @Override
    public GraceJSONResult getDetaAddr(Long id) {
        Address address = addressService.getById(id);
        return GraceJSONResult.ok(address);
    }

    @Override
    public GraceJSONResult getAddressList(Long id) {
        LambdaQueryWrapper<Address> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Address::getUserId,id);
        List<Address> list = addressService.list(queryWrapper);
        return GraceJSONResult.ok(list);
    }

    @Override
    public GraceJSONResult addAddress(AddressForm addressForm) {
        Address address=new Address();
        BeanUtils.copyProperties(addressForm,address);
        boolean res = addressService.save(address);
        if(!res){
            return GraceJSONResult.errorMsg("添加地址失败");
        }
        return GraceJSONResult.ok();
    }

    @Override
    public GraceJSONResult updatePassword() {
        return null;
    }


}
