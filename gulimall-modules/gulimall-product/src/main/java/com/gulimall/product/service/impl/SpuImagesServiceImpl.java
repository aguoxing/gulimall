package com.gulimall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.product.domain.SpuImages;
import com.gulimall.product.mapper.SpuImagesMapper;
import com.gulimall.product.service.ISpuImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * spu图片Service业务层处理
 *
 * @author admin
 * @date 2022-02-14
 */
@Service
public class SpuImagesServiceImpl extends ServiceImpl<SpuImagesMapper, SpuImages> implements ISpuImagesService {
    @Autowired
    private SpuImagesMapper spuImagesMapper;

    /**
     * 查询spu图片
     *
     * @param id spu图片主键
     * @return spu图片
     */
    @Override
    public SpuImages selectSpuImagesById(Long id) {
        return spuImagesMapper.selectById(id);
    }

    /**
     * 查询spu图片列表
     *
     * @param spuImages spu图片
     * @return spu图片
     */
    @Override
    public List<SpuImages> selectSpuImagesList(SpuImages spuImages) {
        return spuImagesMapper.selectSpuImagesList(spuImages);
    }

    /**
     * 新增spu图片
     *
     * @param spuImages spu图片
     * @return 结果
     */
    @Override
    public int insertSpuImages(SpuImages spuImages) {
        return spuImagesMapper.insert(spuImages);
    }

    /**
     * 修改spu图片
     *
     * @param spuImages spu图片
     * @return 结果
     */
    @Override
    public int updateSpuImages(SpuImages spuImages) {
        return spuImagesMapper.updateById(spuImages);
    }

    /**
     * 批量删除spu图片
     *
     * @param ids 需要删除的spu图片主键
     * @return 结果
     */
    @Override
    public int deleteSpuImagesByIds(Long[] ids) {
        return spuImagesMapper.deleteBatchIds(Arrays.asList(ids));
    }

}
