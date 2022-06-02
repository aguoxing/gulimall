package com.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.order.domain.RefundInfo;

import java.util.List;

/**
 * 退款信息Service接口
 *
 * @author admin
 * @date 2022-02-15
 */
public interface IRefundInfoService extends IService<RefundInfo> {
    /**
     * 查询退款信息
     *
     * @param id 退款信息主键
     * @return 退款信息
     */
    RefundInfo selectRefundInfoById(Long id);

    /**
     * 查询退款信息列表
     *
     * @param refundInfo 退款信息
     * @return 退款信息集合
     */
    List<RefundInfo> selectRefundInfoList(RefundInfo refundInfo);

    /**
     * 新增退款信息
     *
     * @param refundInfo 退款信息
     * @return 结果
     */
    int insertRefundInfo(RefundInfo refundInfo);

    /**
     * 修改退款信息
     *
     * @param refundInfo 退款信息
     * @return 结果
     */
    int updateRefundInfo(RefundInfo refundInfo);

    /**
     * 批量删除退款信息
     *
     * @param ids 需要删除的退款信息主键集合
     * @return 结果
     */
    int deleteRefundInfoByIds(Long[] ids);

}
