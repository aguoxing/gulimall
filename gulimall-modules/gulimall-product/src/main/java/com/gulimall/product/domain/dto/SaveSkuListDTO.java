package com.gulimall.product.domain.dto;

import com.gulimall.product.domain.vo.SkuInfoVO;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author gwoksing
 * @date 2022/6/1 8:52
 */
@Data
@ToString
public class SaveSkuListDTO implements Serializable {
    private SpuInfoDTO spuInfoDTO;

    private List<AttrDTO> baseAttrInfoList;

    List<SkuInfoVO> skuInfoVoList;
}
