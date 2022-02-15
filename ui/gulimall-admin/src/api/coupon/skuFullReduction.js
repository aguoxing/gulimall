import request from '@/utils/request'

const service_name = 'coupon/skuFullReduction';

// 查询商品满减信息列表
export function listSkuFullReduction(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询商品满减信息详细
export function getSkuFullReduction(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增商品满减信息
export function addSkuFullReduction(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改商品满减信息
export function updateSkuFullReduction(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除商品满减信息
export function delSkuFullReduction(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
