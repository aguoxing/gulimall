import request from '@/utils/request'

const service_name = 'ware/wareOrderTask';

// 查询库存工作单列表
export function listWareOrderTask(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询库存工作单详细
export function getWareOrderTask(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增库存工作单
export function addWareOrderTask(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改库存工作单
export function updateWareOrderTask(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除库存工作单
export function delWareOrderTask(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
