import request from '@/utils/request'

const service_name = 'ware/purchase';

// 查询采购信息列表
export function listPurchase(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询采购信息详细
export function getPurchase(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增采购信息
export function addPurchase(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改采购信息
export function updatePurchase(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除采购信息
export function delPurchase(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
