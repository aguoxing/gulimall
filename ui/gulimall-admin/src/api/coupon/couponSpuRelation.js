import request from '@/utils/request'

const service_name = 'coupon/couponSpuRelation';

// 查询优惠券与产品关联列表
export function listCouponSpuRelation(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询优惠券与产品关联详细
export function getCouponSpuRelation(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增优惠券与产品关联
export function addCouponSpuRelation(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改优惠券与产品关联
export function updateCouponSpuRelation(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除优惠券与产品关联
export function delCouponSpuRelation(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
