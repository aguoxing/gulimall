import request from '@/utils/request'

const service_name = 'order/refundInfo';

// 查询退款信息列表
export function listRefundInfo(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询退款信息详细
export function getRefundInfo(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增退款信息
export function addRefundInfo(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改退款信息
export function updateRefundInfo(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除退款信息
export function delRefundInfo(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
