import request from '@/utils/request'

const service_name = 'order/orderSetting';

// 查询订单配置信息列表
export function listOrderSetting(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询订单配置信息详细
export function getOrderSetting(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增订单配置信息
export function addOrderSetting(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改订单配置信息
export function updateOrderSetting(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除订单配置信息
export function delOrderSetting(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
