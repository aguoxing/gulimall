import request from '@/utils/request'

const service_name = 'member/memberCollectSubject';

// 查询会员收藏的专题活动列表
export function listMemberCollectSubject(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询会员收藏的专题活动详细
export function getMemberCollectSubject(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增会员收藏的专题活动
export function addMemberCollectSubject(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改会员收藏的专题活动
export function updateMemberCollectSubject(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除会员收藏的专题活动
export function delMemberCollectSubject(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
