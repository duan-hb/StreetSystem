package com.ruoyi.storetype.service.impl;

import com.ruoyi.storetype.domain.StoreType;
import com.ruoyi.storetype.mapper.StoreTypeMapper;
import com.ruoyi.storetype.service.StoreTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class StoreTypeServiceImpl implements StoreTypeService {
    @Autowired
    private StoreTypeMapper storeTypeMapper;

    @Override
    public List<StoreType> list() {
        System.err.println("测试");
        List<StoreType> list = storeTypeMapper.list();
        return list;
    }
}
