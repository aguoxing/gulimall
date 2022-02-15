import request from '@/utils/request'

const service_name = 'coupon/seckillPromotion';

// 查询秒杀活动列表
export function listSeckillPromotion(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询秒杀活动详细
export function getSeckillPromotion(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增秒杀活动
export function addSeckillPromotion(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改秒杀活动
export function updateSeckillPromotion(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除秒杀活动
export function delSeckillPromotion(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
