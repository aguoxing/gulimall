import request from '@/utils/request'

const service_name = 'order/order';

// 查询订单列表
export function listOrder(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询订单详细
export function getOrder(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增订单
export function addOrder(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改订单
export function updateOrder(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除订单
export function delOrder(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
