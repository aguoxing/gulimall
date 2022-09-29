import request from '@/utils/request'

const service_name = 'product/spuInfo';

// 查询spu信息列表
export function listSpuInfo(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询spu信息详细
export function getSpuInfo(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增spu信息
export function addSpuInfo(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改spu信息
export function updateSpuInfo(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除spu信息
export function delSpuInfo(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}

// 发布商品
export function saveSpu(data) {
  return request({
    url: `/${service_name}/saveSpu`,
    method: 'post',
    data: data
  })
}
