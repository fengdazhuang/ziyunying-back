package com.fzz.all.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fzz.all.mapper.AppUserMapper;
import com.fzz.all.service.AppUserService;
import com.fzz.pojo.AppUser;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl extends ServiceImpl<AppUserMapper, AppUser> implements AppUserService {
    @Override
    public AppUser isExists(String username) {
        LambdaQueryWrapper<AppUser> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(AppUser::getPhone,username);
        return this.getOne(queryWrapper);
    }

    @Override
    public boolean saveNewUser(AppUser appUser) {

        return this.save(appUser);
    }
}
