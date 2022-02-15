import request from '@/utils/request'

const service_name = 'coupon/spuBounds';

// 查询商品spu积分设置列表
export function listSpuBounds(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询商品spu积分设置详细
export function getSpuBounds(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增商品spu积分设置
export function addSpuBounds(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改商品spu积分设置
export function updateSpuBounds(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除商品spu积分设置
export function delSpuBounds(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
