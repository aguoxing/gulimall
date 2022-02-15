package com.gulimall.product.service.impl;

import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.product.mapper.AttrMapper;
import com.gulimall.product.domain.Attr;
import com.gulimall.product.service.IAttrService;

/**
 * 商品属性Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr> implements IAttrService {
    @Autowired
    private AttrMapper attrMapper;

    /**
     * 查询商品属性
     * 
     * @param attrId 商品属性主键
     * @return 商品属性
     */
    @Override
    public Attr selectAttrByAttrId(Long attrId) {
        return attrMapper.selectById(attrId);
    }

    /**
     * 查询商品属性列表
     * 
     * @param attr 商品属性
     * @return 商品属性
     */
    @Override
    public List<Attr> selectAttrList(Attr attr) {
        return attrMapper.selectAttrList(attr);
    }

    /**
     * 新增商品属性
     * 
     * @param attr 商品属性
     * @return 结果
     */
    @Override
    public int insertAttr(Attr attr) {
        return attrMapper.insert(attr);
    }

    /**
     * 修改商品属性
     * 
     * @param attr 商品属性
     * @return 结果
     */
    @Override
    public int updateAttr(Attr attr) {
        return attrMapper.updateById(attr);
    }

    /**
     * 批量删除商品属性
     * 
     * @param attrIds 需要删除的商品属性主键
     * @return 结果
     */
    @Override
    public int deleteAttrByAttrIds(Long[] attrIds) {
        return attrMapper.deleteBatchIds(Arrays.asList(attrIds));
    }

}
