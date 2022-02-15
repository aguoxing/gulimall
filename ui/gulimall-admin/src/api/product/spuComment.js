import request from '@/utils/request'

const service_name = 'product/spuComment';

// 查询商品评价列表
export function listSpuComment(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询商品评价详细
export function getSpuComment(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增商品评价
export function addSpuComment(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改商品评价
export function updateSpuComment(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除商品评价
export function delSpuComment(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
