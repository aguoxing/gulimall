package com.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.product.domain.CommentReplay;

import java.util.List;

/**
 * 商品评价回复关系Service接口
 *
 * @author admin
 * @date 2022-02-14
 */
public interface ICommentReplayService extends IService<CommentReplay> {
    /**
     * 查询商品评价回复关系
     *
     * @param id 商品评价回复关系主键
     * @return 商品评价回复关系
     */
    CommentReplay selectCommentReplayById(Long id);

    /**
     * 查询商品评价回复关系列表
     *
     * @param commentReplay 商品评价回复关系
     * @return 商品评价回复关系集合
     */
    List<CommentReplay> selectCommentReplayList(CommentReplay commentReplay);

    /**
     * 新增商品评价回复关系
     *
     * @param commentReplay 商品评价回复关系
     * @return 结果
     */
    int insertCommentReplay(CommentReplay commentReplay);

    /**
     * 修改商品评价回复关系
     *
     * @param commentReplay 商品评价回复关系
     * @return 结果
     */
    int updateCommentReplay(CommentReplay commentReplay);

    /**
     * 批量删除商品评价回复关系
     *
     * @param ids 需要删除的商品评价回复关系主键集合
     * @return 结果
     */
    int deleteCommentReplayByIds(Long[] ids);

}
