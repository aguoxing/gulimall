import request from '@/utils/request'

const service_name = 'coupon/seckillSession';

// 查询秒杀活动场次列表
export function listSeckillSession(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询秒杀活动场次详细
export function getSeckillSession(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增秒杀活动场次
export function addSeckillSession(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改秒杀活动场次
export function updateSeckillSession(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除秒杀活动场次
export function delSeckillSession(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
