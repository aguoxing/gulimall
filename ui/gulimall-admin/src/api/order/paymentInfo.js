import request from '@/utils/request'

const service_name = 'order/paymentInfo';

// 查询支付信息列表
export function listPaymentInfo(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询支付信息详细
export function getPaymentInfo(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增支付信息
export function addPaymentInfo(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改支付信息
export function updatePaymentInfo(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除支付信息
export function delPaymentInfo(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
