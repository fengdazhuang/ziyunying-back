package com.fzz.all.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fzz.all.mapper.MyCollectionsMapper;
import com.fzz.all.service.MyCollectionsService;
import com.fzz.pojo.MyCollections;
import org.springframework.stereotype.Service;

@Service
public class MyCollectionsServiceImpl extends ServiceImpl<MyCollectionsMapper, MyCollections> implements MyCollectionsService {
}
