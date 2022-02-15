import request from '@/utils/request'

const service_name = 'coupon/homeAdv';

// 查询首页轮播广告列表
export function listHomeAdv(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询首页轮播广告详细
export function getHomeAdv(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增首页轮播广告
export function addHomeAdv(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改首页轮播广告
export function updateHomeAdv(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除首页轮播广告
export function delHomeAdv(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
