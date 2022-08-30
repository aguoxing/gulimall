package com.gulimall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.common.core.utils.DateUtils;
import com.gulimall.product.domain.SpuComment;
import com.gulimall.product.mapper.SpuCommentMapper;
import com.gulimall.product.service.ISpuCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 商品评价Service业务层处理
 *
 * @author admin
 * @date 2022-02-14
 */
@Service
public class SpuCommentServiceImpl extends ServiceImpl<SpuCommentMapper, SpuComment> implements ISpuCommentService {
    @Autowired
    private SpuCommentMapper spuCommentMapper;

    /**
     * 查询商品评价
     *
     * @param id 商品评价主键
     * @return 商品评价
     */
    @Override
    public SpuComment selectSpuCommentById(Long id) {
        return spuCommentMapper.selectById(id);
    }

    /**
     * 查询商品评价列表
     *
     * @param spuComment 商品评价
     * @return 商品评价
     */
    @Override
    public List<SpuComment> selectSpuCommentList(SpuComment spuComment) {
        return spuCommentMapper.selectSpuCommentList(spuComment);
    }

    /**
     * 新增商品评价
     *
     * @param spuComment 商品评价
     * @return 结果
     */
    @Override
    public int insertSpuComment(SpuComment spuComment) {
        spuComment.setCreateTime(DateUtils.getNowDate());
        return spuCommentMapper.insert(spuComment);
    }

    /**
     * 修改商品评价
     *
     * @param spuComment 商品评价
     * @return 结果
     */
    @Override
    public int updateSpuComment(SpuComment spuComment) {
        return spuCommentMapper.updateById(spuComment);
    }

    /**
     * 批量删除商品评价
     *
     * @param ids 需要删除的商品评价主键
     * @return 结果
     */
    @Override
    public int deleteSpuCommentByIds(Long[] ids) {
        return spuCommentMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
