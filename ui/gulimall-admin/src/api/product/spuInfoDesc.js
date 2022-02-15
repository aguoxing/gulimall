import request from '@/utils/request'

const service_name = 'product/spuInfoDesc';

// 查询spu信息介绍列表
export function listSpuInfoDesc(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询spu信息介绍详细
export function getSpuInfoDesc(spuId) {
  return request({
    url: `/${service_name}/` + spuId,
    method: 'get'
  })
}

// 新增spu信息介绍
export function addSpuInfoDesc(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改spu信息介绍
export function updateSpuInfoDesc(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除spu信息介绍
export function delSpuInfoDesc(spuId) {
  return request({
    url: `/${service_name}/` + spuId,
    method: 'delete'
  })
}
