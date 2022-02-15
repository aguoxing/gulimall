import request from '@/utils/request'

const service_name = 'ware/wareOrderTaskDetail';

// 查询库存工作单详情列表
export function listWareOrderTaskDetail(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询库存工作单详情详细
export function getWareOrderTaskDetail(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增库存工作单详情
export function addWareOrderTaskDetail(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改库存工作单详情
export function updateWareOrderTaskDetail(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除库存工作单详情
export function delWareOrderTaskDetail(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
