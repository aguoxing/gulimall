import request from '@/utils/request'

const service_name = 'product/replay';

// 查询商品评价回复关系列表
export function listReplay(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询商品评价回复关系详细
export function getReplay(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增商品评价回复关系
export function addReplay(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改商品评价回复关系
export function updateReplay(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除商品评价回复关系
export function delReplay(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
