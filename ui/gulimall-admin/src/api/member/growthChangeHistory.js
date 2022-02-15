import request from '@/utils/request'

const service_name = 'member/growthChangeHistory';

// 查询成长值变化历史记录列表
export function listGrowthChangeHistory(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询成长值变化历史记录详细
export function getGrowthChangeHistory(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增成长值变化历史记录
export function addGrowthChangeHistory(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改成长值变化历史记录
export function updateGrowthChangeHistory(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除成长值变化历史记录
export function delGrowthChangeHistory(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
