import request from '@/utils/request'

const service_name = 'coupon/homeSubjectSpu';

// 查询专题商品列表
export function listHomeSubjectSpu(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询专题商品详细
export function getHomeSubjectSpu(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增专题商品
export function addHomeSubjectSpu(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改专题商品
export function updateHomeSubjectSpu(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除专题商品
export function delHomeSubjectSpu(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
