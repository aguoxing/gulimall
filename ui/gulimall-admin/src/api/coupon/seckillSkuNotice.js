import request from '@/utils/request'

const service_name = 'coupon/seckillSkuNotice';

// 查询秒杀商品通知订阅列表
export function listSeckillSkuNotice(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询秒杀商品通知订阅详细
export function getSeckillSkuNotice(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增秒杀商品通知订阅
export function addSeckillSkuNotice(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改秒杀商品通知订阅
export function updateSeckillSkuNotice(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除秒杀商品通知订阅
export function delSeckillSkuNotice(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
