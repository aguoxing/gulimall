import request from '@/utils/request'

const service_name = 'member/memberCollectSpu';

// 查询会员收藏的商品列表
export function listMemberCollectSpu(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询会员收藏的商品详细
export function getMemberCollectSpu(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增会员收藏的商品
export function addMemberCollectSpu(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改会员收藏的商品
export function updateMemberCollectSpu(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除会员收藏的商品
export function delMemberCollectSpu(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
