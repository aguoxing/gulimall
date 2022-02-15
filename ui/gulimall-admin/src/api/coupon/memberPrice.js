import request from '@/utils/request'

const service_name = 'coupon/memberPrice';

// 查询商品会员价格列表
export function listMemberPrice(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询商品会员价格详细
export function getMemberPrice(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增商品会员价格
export function addMemberPrice(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改商品会员价格
export function updateMemberPrice(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除商品会员价格
export function delMemberPrice(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
