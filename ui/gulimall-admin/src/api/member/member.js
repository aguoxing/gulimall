import request from '@/utils/request'

const service_name = 'member/member';

// 查询会员列表
export function listMember(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询会员详细
export function getMember(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增会员
export function addMember(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改会员
export function updateMember(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除会员
export function delMember(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
