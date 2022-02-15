import request from '@/utils/request'

const service_name = 'coupon/homeSubject';

// 查询首页专题列表
export function listHomeSubject(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询首页专题详细
export function getHomeSubject(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增首页专题
export function addHomeSubject(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改首页专题
export function updateHomeSubject(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除首页专题
export function delHomeSubject(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
