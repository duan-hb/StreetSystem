package com.ruoyi.storetype.mapper;

import com.ruoyi.storetype.domain.StoreType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreTypeMapper {

    List<StoreType> list();
}
