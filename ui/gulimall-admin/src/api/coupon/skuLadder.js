import request from '@/utils/request'

const service_name = 'coupon/skuLadder';

// 查询商品阶梯价格列表
export function listSkuLadder(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询商品阶梯价格详细
export function getSkuLadder(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增商品阶梯价格
export function addSkuLadder(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改商品阶梯价格
export function updateSkuLadder(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除商品阶梯价格
export function delSkuLadder(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
