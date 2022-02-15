import request from '@/utils/request'

const service_name = 'member/memberLoginLog';

// 查询会员登录记录列表
export function listMemberLoginLog(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询会员登录记录详细
export function getMemberLoginLog(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增会员登录记录
export function addMemberLoginLog(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改会员登录记录
export function updateMemberLoginLog(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除会员登录记录
export function delMemberLoginLog(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
