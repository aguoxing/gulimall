package com.gulimall.ware.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.ware.entity.Purchase;
import com.gulimall.ware.mapper.PurchaseMapper;
import com.gulimall.ware.service.PurchaseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 采购信息 服务实现类
 * </p>
 *
 * @author guoxing
 * @since 2020-10-21
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {

}
