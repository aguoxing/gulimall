package com.gulimall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.product.domain.SpuComment;

import java.util.List;

/**
 * 商品评价Mapper接口
 *
 * @author admin
 * @date 2022-02-14
 */
public interface SpuCommentMapper extends BaseMapper<SpuComment> {

    /**
     * 查询商品评价列表
     *
     * @param spuComment 商品评价
     * @return 商品评价集合
     */
    List<SpuComment> selectSpuCommentList(SpuComment spuComment);

}
