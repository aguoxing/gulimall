package com.gulimall.ware.vo;

import lombok.Data;

import java.util.List;

@Data
public class MergeVo {

    // 整单id
    private Long purchaseId;
    // [1,2,3,4] //合并项集合
    private List<Long> items;
}
