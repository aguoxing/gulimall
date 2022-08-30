package com.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.product.domain.AttrEntity;
import com.gulimall.product.domain.AttrGroup;
import com.gulimall.product.domain.AttrGroupRelation;
import com.gulimall.product.domain.dto.AttrDTO;
import com.gulimall.product.domain.vo.AttrGroupWithAttrVO;
import com.gulimall.product.domain.vo.AttrGroupWithBaseAttrVO;
import com.gulimall.product.mapper.AttrGroupMapper;
import com.gulimall.product.service.IAttrGroupService;
import com.gulimall.product.service.IAttrService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 属性分组Service业务层处理
 *
 * @author admin
 * @date 2022-02-14
 */
@Service
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroup> implements IAttrGroupService {
    @Autowired
    private AttrGroupMapper attrGroupMapper;
    @Autowired
    private IAttrService attrService;

    /**
     * 查询属性分组
     *
     * @param attrGroupId 属性分组主键
     * @return 属性分组
     */
    @Override
    public AttrGroup selectAttrGroupByAttrGroupId(Long attrGroupId) {
        return attrGroupMapper.selectById(attrGroupId);
    }

    /**
     * 查询属性分组列表
     *
     * @param attrGroup 属性分组
     * @return 属性分组
     */
    @Override
    public List<AttrGroup> selectAttrGroupList(AttrGroup attrGroup) {
        return attrGroupMapper.selectAttrGroupList(attrGroup);
    }

    /**
     * 新增属性分组
     *
     * @param attrGroup 属性分组
     * @return 结果
     */
    @Override
    public int insertAttrGroup(AttrGroup attrGroup) {
        return attrGroupMapper.insert(attrGroup);
    }

    /**
     * 修改属性分组
     *
     * @param attrGroup 属性分组
     * @return 结果
     */
    @Override
    public int updateAttrGroup(AttrGroup attrGroup) {
        return attrGroupMapper.updateById(attrGroup);
    }

    /**
     * 批量删除属性分组
     *
     * @param attrGroupIds 需要删除的属性分组主键
     * @return 结果
     */
    @Override
    public int deleteAttrGroupByAttrGroupIds(Long[] attrGroupIds) {
        return attrGroupMapper.deleteBatchIds(Arrays.asList(attrGroupIds));
    }

    /**
     * 获取属性组&属性信息
     *
     * @param attrGroup
     * @return
     */
    @Override
    public AttrGroupWithAttrVO getAttrGroupWithAttrVo(AttrGroup attrGroup) {
        AttrGroupWithAttrVO attrGroupWithAttrVO = new AttrGroupWithAttrVO();
        List<AttrGroupWithBaseAttrVO> attrGroupWithBaseAttrVOList = new ArrayList<>();

        // 属性组&基本规格信息
        List<AttrGroup> attrGroupList = attrGroupMapper.selectList(new LambdaQueryWrapper<AttrGroup>().eq(AttrGroup::getCatalogId, attrGroup.getCatalogId()));
        for (AttrGroup group : attrGroupList) {
            List<AttrDTO> baseAttrInfoList = new ArrayList<>();
            AttrGroupWithBaseAttrVO attrGroupWithBaseAttrVO = new AttrGroupWithBaseAttrVO();
            attrGroupWithBaseAttrVO.setAttrGroupName(group.getAttrGroupName());

            AttrGroupRelation attrGroupRelation = new AttrGroupRelation();
            attrGroupRelation.setAttrGroupId(group.getAttrGroupId());
            List<AttrEntity> attrEntityList = attrService.selectAttrByAttrGroupId(attrGroupRelation);
            for (AttrEntity attrEntity : attrEntityList) {
                if (attrEntity.getAttrType() != 0) {
                    AttrDTO attrDTO = new AttrDTO();
                    BeanUtils.copyProperties(attrEntity, attrDTO);
                    attrDTO.setAttrValues(new ArrayList<>());
                    baseAttrInfoList.add(attrDTO);
                }
            }

            attrGroupWithBaseAttrVO.setBaseAttrInfoList(baseAttrInfoList);
            attrGroupWithBaseAttrVOList.add(attrGroupWithBaseAttrVO);
        }

        // 销售属性
        List<AttrDTO> saleAttrInfoList = new ArrayList<>();
        List<AttrEntity> saleAttrList = attrService.list();
        for (AttrEntity saleEntity : saleAttrList) {
            if (saleEntity.getAttrType() != 1) {
                AttrDTO saleAttrDto = new AttrDTO();
                BeanUtils.copyProperties(saleEntity, saleAttrDto);
                saleAttrDto.setAttrValues(new ArrayList<>());
                saleAttrInfoList.add(saleAttrDto);
            }
        }

        attrGroupWithAttrVO.setSaleAttrInfoList(saleAttrInfoList);
        attrGroupWithAttrVO.setAttrGroupWithBaseAttrVOList(attrGroupWithBaseAttrVOList);
        return attrGroupWithAttrVO;
    }

}
