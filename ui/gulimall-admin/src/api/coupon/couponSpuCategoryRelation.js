import request from '@/utils/request'

const service_name = 'coupon/couponSpuCategoryRelation';

// 查询优惠券分类关联列表
export function listCouponSpuCategoryRelation(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询优惠券分类关联详细
export function getCouponSpuCategoryRelation(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增优惠券分类关联
export function addCouponSpuCategoryRelation(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改优惠券分类关联
export function updateCouponSpuCategoryRelation(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除优惠券分类关联
export function delCouponSpuCategoryRelation(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
