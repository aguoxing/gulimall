import request from '@/utils/request'

const service_name = 'member/integrationChangeHistory';

// 查询积分变化历史记录列表
export function listIntegrationChangeHistory(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询积分变化历史记录详细
export function getIntegrationChangeHistory(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增积分变化历史记录
export function addIntegrationChangeHistory(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改积分变化历史记录
export function updateIntegrationChangeHistory(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除积分变化历史记录
export function delIntegrationChangeHistory(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
