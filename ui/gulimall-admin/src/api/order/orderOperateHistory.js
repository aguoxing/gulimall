import request from '@/utils/request'

const service_name = 'order/orderOperateHistory';

// 查询订单操作历史记录列表
export function listOrderOperateHistory(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询订单操作历史记录详细
export function getOrderOperateHistory(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增订单操作历史记录
export function addOrderOperateHistory(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改订单操作历史记录
export function updateOrderOperateHistory(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除订单操作历史记录
export function delOrderOperateHistory(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
