import request from '@/utils/request'

const service_name = 'member/memberReceiveAddress';

// 查询会员收货地址列表
export function listMemberReceiveAddress(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询会员收货地址详细
export function getMemberReceiveAddress(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增会员收货地址
export function addMemberReceiveAddress(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改会员收货地址
export function updateMemberReceiveAddress(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除会员收货地址
export function delMemberReceiveAddress(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
