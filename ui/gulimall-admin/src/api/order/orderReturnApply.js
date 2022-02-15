import request from '@/utils/request'

const service_name = 'order/orderReturnApply';

// 查询订单退货申请列表
export function listOrderReturnApply(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询订单退货申请详细
export function getOrderReturnApply(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增订单退货申请
export function addOrderReturnApply(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改订单退货申请
export function updateOrderReturnApply(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除订单退货申请
export function delOrderReturnApply(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
