package com.fzz.all.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fzz.pojo.AppUser;

public interface AppUserService extends IService<AppUser> {

    AppUser isExists(String phone);

    boolean saveNewUser(AppUser appUser);
}
