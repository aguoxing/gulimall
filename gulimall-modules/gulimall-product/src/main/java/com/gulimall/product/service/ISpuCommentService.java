package com.gulimall.product.service;

import java.util.List;
import com.gulimall.product.domain.SpuComment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 商品评价Service接口
 * 
 * @author admin
 * @date 2022-02-14
 */
public interface ISpuCommentService extends IService<SpuComment> {
    /**
     * 查询商品评价
     *
     * @param id 商品评价主键
     * @return 商品评价
     */
    SpuComment selectSpuCommentById(Long id);

    /**
     * 查询商品评价列表
     * 
     * @param spuComment 商品评价
     * @return 商品评价集合
     */
    List<SpuComment> selectSpuCommentList(SpuComment spuComment);

    /**
     * 新增商品评价
     * 
     * @param spuComment 商品评价
     * @return 结果
     */
    int insertSpuComment(SpuComment spuComment);

    /**
     * 修改商品评价
     * 
     * @param spuComment 商品评价
     * @return 结果
     */
    int updateSpuComment(SpuComment spuComment);

    /**
     * 批量删除商品评价
     * 
     * @param ids 需要删除的商品评价主键集合
     * @return 结果
     */
    int deleteSpuCommentByIds(Long[] ids);

}
