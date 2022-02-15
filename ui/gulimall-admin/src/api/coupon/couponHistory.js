import request from '@/utils/request'

const service_name = 'coupon/couponHistory';

// 查询优惠券领取历史记录列表
export function listCouponHistory(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询优惠券领取历史记录详细
export function getCouponHistory(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增优惠券领取历史记录
export function addCouponHistory(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改优惠券领取历史记录
export function updateCouponHistory(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除优惠券领取历史记录
export function delCouponHistory(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
