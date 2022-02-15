import request from '@/utils/request'

const service_name = 'member/memberStatisticsInfo';

// 查询会员统计信息列表
export function listMemberStatisticsInfo(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询会员统计信息详细
export function getMemberStatisticsInfo(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增会员统计信息
export function addMemberStatisticsInfo(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改会员统计信息
export function updateMemberStatisticsInfo(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除会员统计信息
export function delMemberStatisticsInfo(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
