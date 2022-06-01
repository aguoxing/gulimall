import request from '@/utils/request'

const service_name = 'product/skuInfo';

// 查询sku信息列表
export function listSkuInfo(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询sku信息详细
export function getSkuInfo(skuId) {
  return request({
    url: `/${service_name}/` + skuId,
    method: 'get'
  })
}

// 新增sku信息
export function addSkuInfo(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改sku信息
export function updateSkuInfo(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除sku信息
export function delSkuInfo(skuId) {
  return request({
    url: `/${service_name}/` + skuId,
    method: 'delete'
  })
}

export function genSkuList(data) {
  return request({
    url: `/${service_name}/genSkuList`,
    method: 'post',
    data: data
  })
}

export function saveSkuList(data) {
  return request({
    url: `/${service_name}/saveSkuList`,
    method: 'post',
    data: data
  })
}
