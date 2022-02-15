import request from '@/utils/request'

const service_name = 'coupon/coupon';

// 查询优惠券信息列表
export function listCoupon(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询优惠券信息详细
export function getCoupon(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增优惠券信息
export function addCoupon(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改优惠券信息
export function updateCoupon(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除优惠券信息
export function delCoupon(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
