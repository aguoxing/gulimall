package com.gulimall.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.order.domain.RefundInfo;

import java.util.List;

/**
 * 退款信息Mapper接口
 *
 * @author admin
 * @date 2022-02-15
 */
public interface RefundInfoMapper extends BaseMapper<RefundInfo> {

    /**
     * 查询退款信息列表
     *
     * @param refundInfo 退款信息
     * @return 退款信息集合
     */
    List<RefundInfo> selectRefundInfoList(RefundInfo refundInfo);

}
