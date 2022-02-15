import request from '@/utils/request'

const service_name = 'ware/wareInfo';

// 查询仓库信息列表
export function listWareInfo(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询仓库信息详细
export function getWareInfo(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增仓库信息
export function addWareInfo(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改仓库信息
export function updateWareInfo(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除仓库信息
export function delWareInfo(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
