package com.gulimall.ware.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gulimall.ware.domain.WareInfo;

/**
 * 仓库信息Mapper接口
 * 
 * @author admin
 * @date 2022-02-15
 */
public interface WareInfoMapper extends BaseMapper<WareInfo> {

    /**
     * 查询仓库信息列表
     * 
     * @param wareInfo 仓库信息
     * @return 仓库信息集合
     */
    List<WareInfo> selectWareInfoList(WareInfo wareInfo);

}
