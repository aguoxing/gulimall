package com.gulimall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.product.domain.CommentReplay;

import java.util.List;

/**
 * 商品评价回复关系Mapper接口
 *
 * @author admin
 * @date 2022-02-14
 */
public interface CommentReplayMapper extends BaseMapper<CommentReplay> {

    /**
     * 查询商品评价回复关系列表
     *
     * @param commentReplay 商品评价回复关系
     * @return 商品评价回复关系集合
     */
    List<CommentReplay> selectCommentReplayList(CommentReplay commentReplay);

}
