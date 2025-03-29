package com.ruoyi.merchantsstore.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Primary;

public interface MerchantsStoreMapper {
    int updateMerchantsStore(@Param("oldId") Long oldId,@Param("newId") int newId,@Param("storeId") Long storeId);

    int deletStore(Long[] ids);

    int updateMerchantsIdToZero(Long[] ids);
}
