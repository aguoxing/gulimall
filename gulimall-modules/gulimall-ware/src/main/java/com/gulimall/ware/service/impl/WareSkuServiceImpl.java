package com.gulimall.ware.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.ware.mapper.WareSkuMapper;
import com.gulimall.ware.domain.WareSku;
import com.gulimall.ware.service.IWareSkuService;

/**
 * 商品库存Service业务层处理
 * 
 * @author admin
 * @date 2022-02-15
 */
@Service
public class WareSkuServiceImpl extends ServiceImpl<WareSkuMapper, WareSku> implements IWareSkuService {
    @Autowired
    private WareSkuMapper wareSkuMapper;

    /**
     * 查询商品库存
     * 
     * @param id 商品库存主键
     * @return 商品库存
     */
    @Override
    public WareSku selectWareSkuById(Long id) {
        return wareSkuMapper.selectById(id);
    }

    /**
     * 查询商品库存列表
     * 
     * @param wareSku 商品库存
     * @return 商品库存
     */
    @Override
    public List<WareSku> selectWareSkuList(WareSku wareSku) {
        return wareSkuMapper.selectWareSkuList(wareSku);
    }

    /**
     * 新增商品库存
     * 
     * @param wareSku 商品库存
     * @return 结果
     */
    @Override
    public int insertWareSku(WareSku wareSku) {
        return wareSkuMapper.insert(wareSku);
    }

    /**
     * 修改商品库存
     * 
     * @param wareSku 商品库存
     * @return 结果
     */
    @Override
    public int updateWareSku(WareSku wareSku) {
        return wareSkuMapper.updateById(wareSku);
    }

    /**
     * 批量删除商品库存
     * 
     * @param ids 需要删除的商品库存主键
     * @return 结果
     */
    @Override
    public int deleteWareSkuByIds(Long[] ids) {
        return wareSkuMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
