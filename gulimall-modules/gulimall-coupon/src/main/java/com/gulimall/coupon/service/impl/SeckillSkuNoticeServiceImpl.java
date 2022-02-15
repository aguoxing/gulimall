package com.gulimall.coupon.service.impl;

import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupon.mapper.SeckillSkuNoticeMapper;
import com.gulimall.coupon.domain.SeckillSkuNotice;
import com.gulimall.coupon.service.ISeckillSkuNoticeService;

/**
 * 秒杀商品通知订阅Service业务层处理
 * 
 * @author admin
 * @date 2022-02-14
 */
@Service
public class SeckillSkuNoticeServiceImpl extends ServiceImpl<SeckillSkuNoticeMapper, SeckillSkuNotice> implements ISeckillSkuNoticeService {
    @Autowired
    private SeckillSkuNoticeMapper seckillSkuNoticeMapper;

    /**
     * 查询秒杀商品通知订阅
     * 
     * @param id 秒杀商品通知订阅主键
     * @return 秒杀商品通知订阅
     */
    @Override
    public SeckillSkuNotice selectSeckillSkuNoticeById(Long id) {
        return seckillSkuNoticeMapper.selectById(id);
    }

    /**
     * 查询秒杀商品通知订阅列表
     * 
     * @param seckillSkuNotice 秒杀商品通知订阅
     * @return 秒杀商品通知订阅
     */
    @Override
    public List<SeckillSkuNotice> selectSeckillSkuNoticeList(SeckillSkuNotice seckillSkuNotice) {
        return seckillSkuNoticeMapper.selectSeckillSkuNoticeList(seckillSkuNotice);
    }

    /**
     * 新增秒杀商品通知订阅
     * 
     * @param seckillSkuNotice 秒杀商品通知订阅
     * @return 结果
     */
    @Override
    public int insertSeckillSkuNotice(SeckillSkuNotice seckillSkuNotice) {
        return seckillSkuNoticeMapper.insert(seckillSkuNotice);
    }

    /**
     * 修改秒杀商品通知订阅
     * 
     * @param seckillSkuNotice 秒杀商品通知订阅
     * @return 结果
     */
    @Override
    public int updateSeckillSkuNotice(SeckillSkuNotice seckillSkuNotice) {
        return seckillSkuNoticeMapper.updateById(seckillSkuNotice);
    }

    /**
     * 批量删除秒杀商品通知订阅
     * 
     * @param ids 需要删除的秒杀商品通知订阅主键
     * @return 结果
     */
    @Override
    public int deleteSeckillSkuNoticeByIds(Long[] ids) {
        return seckillSkuNoticeMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
