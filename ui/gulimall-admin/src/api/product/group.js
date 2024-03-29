import request from '@/utils/request'

const service_name = 'product/group';

// 查询属性分组列表
export function listGroup(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询属性分组详细
export function getGroup(attrGroupId) {
  return request({
    url: `/${service_name}/` + attrGroupId,
    method: 'get'
  })
}

// 新增属性分组
export function addGroup(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改属性分组
export function updateGroup(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除属性分组
export function delGroup(attrGroupId) {
  return request({
    url: `/${service_name}/` + attrGroupId,
    method: 'delete'
  })
}

// 查询属性分组Vo
export function getAttrGroupWithAttrVo(query) {
  return request({
    url: `/${service_name}/getAttrGroupWithAttrVo`,
    method: 'get',
    params: query
  })
}
