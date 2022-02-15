package com.gulimall.product.service.impl;

import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.product.mapper.CommentReplayMapper;
import com.gulimall.product.domain.CommentReplay;
import com.gulimall.product.service.ICommentReplayService;

/**
 * 商品评价回复关系Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class CommentReplayServiceImpl extends ServiceImpl<CommentReplayMapper, CommentReplay> implements ICommentReplayService {
    @Autowired
    private CommentReplayMapper commentReplayMapper;

    /**
     * 查询商品评价回复关系
     * 
     * @param id 商品评价回复关系主键
     * @return 商品评价回复关系
     */
    @Override
    public CommentReplay selectCommentReplayById(Long id) {
        return commentReplayMapper.selectById(id);
    }

    /**
     * 查询商品评价回复关系列表
     * 
     * @param commentReplay 商品评价回复关系
     * @return 商品评价回复关系
     */
    @Override
    public List<CommentReplay> selectCommentReplayList(CommentReplay commentReplay) {
        return commentReplayMapper.selectCommentReplayList(commentReplay);
    }

    /**
     * 新增商品评价回复关系
     * 
     * @param commentReplay 商品评价回复关系
     * @return 结果
     */
    @Override
    public int insertCommentReplay(CommentReplay commentReplay) {
        return commentReplayMapper.insert(commentReplay);
    }

    /**
     * 修改商品评价回复关系
     * 
     * @param commentReplay 商品评价回复关系
     * @return 结果
     */
    @Override
    public int updateCommentReplay(CommentReplay commentReplay) {
        return commentReplayMapper.updateById(commentReplay);
    }

    /**
     * 批量删除商品评价回复关系
     * 
     * @param ids 需要删除的商品评价回复关系主键
     * @return 结果
     */
    @Override
    public int deleteCommentReplayByIds(Long[] ids) {
        return commentReplayMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
