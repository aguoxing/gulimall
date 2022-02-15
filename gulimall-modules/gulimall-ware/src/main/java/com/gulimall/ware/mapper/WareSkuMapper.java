package com.gulimall.ware.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.ware.domain.WareSku;

/**
 * 商品库存Mapper接口
 * 
 * @author admin
 * @date 2022-02-15
 */
public interface WareSkuMapper extends BaseMapper<WareSku> {

    /**
     * 查询商品库存列表
     * 
     * @param wareSku 商品库存
     * @return 商品库存集合
     */
    List<WareSku> selectWareSkuList(WareSku wareSku);

}
