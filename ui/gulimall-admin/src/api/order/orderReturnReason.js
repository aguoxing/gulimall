import request from '@/utils/request'

const service_name = 'order/orderReturnReason';

// 查询退货原因列表
export function listOrderReturnReason(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询退货原因详细
export function getOrderReturnReason(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增退货原因
export function addOrderReturnReason(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改退货原因
export function updateOrderReturnReason(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除退货原因
export function delOrderReturnReason(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
