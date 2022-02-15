import request from '@/utils/request'

const service_name = 'ware/purchaseDetail';

// 查询采购信息详情列表
export function listPurchaseDetail(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询采购信息详情详细
export function getPurchaseDetail(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增采购信息详情
export function addPurchaseDetail(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改采购信息详情
export function updatePurchaseDetail(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除采购信息详情
export function delPurchaseDetail(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
