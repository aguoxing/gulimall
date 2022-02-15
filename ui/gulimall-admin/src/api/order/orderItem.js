import request from '@/utils/request'

const service_name = 'order/orderItem';

// 查询订单项信息列表
export function listOrderItem(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询订单项信息详细
export function getOrderItem(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增订单项信息
export function addOrderItem(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改订单项信息
export function updateOrderItem(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除订单项信息
export function delOrderItem(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
