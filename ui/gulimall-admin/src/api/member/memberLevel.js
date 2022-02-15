import request from '@/utils/request'

const service_name = 'member/memberLevel';

// 查询会员等级列表
export function listMemberLevel(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询会员等级详细
export function getMemberLevel(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增会员等级
export function addMemberLevel(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改会员等级
export function updateMemberLevel(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除会员等级
export function delMemberLevel(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
