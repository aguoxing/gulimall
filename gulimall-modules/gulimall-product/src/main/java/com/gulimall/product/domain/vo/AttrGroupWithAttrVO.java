package com.gulimall.product.domain.vo;

import com.gulimall.product.domain.dto.AttrDTO;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author gwoksing
 * @date 2022/5/31 11:23
 */
@Data
@ToString
public class AttrGroupWithAttrVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<AttrGroupWithBaseAttrVO> attrGroupWithBaseAttrVOList;

    private List<AttrDTO> saleAttrInfoList;

}
