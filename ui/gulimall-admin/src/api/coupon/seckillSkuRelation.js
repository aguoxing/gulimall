import request from '@/utils/request'

const service_name = 'coupon/seckillSkuRelation';

// 查询秒杀活动商品关联列表
export function listSeckillSkuRelation(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询秒杀活动商品关联详细
export function getSeckillSkuRelation(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增秒杀活动商品关联
export function addSeckillSkuRelation(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改秒杀活动商品关联
export function updateSeckillSkuRelation(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除秒杀活动商品关联
export function delSeckillSkuRelation(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
