package com.ruoyi.merchantsstore.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MerchantsStore {
    private Long id;
    private Long mid;//商户id
    private Long sid;//店铺id
}
