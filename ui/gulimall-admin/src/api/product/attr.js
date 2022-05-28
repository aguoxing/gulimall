import request from '@/utils/request'

const service_name = 'product/attr';

// 查询商品属性列表
export function listAttr(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询已关联的商品属性列表
export function listAttrRelation(query) {
  return request({
    url: `/${service_name}/attrRelation`,
    method: 'get',
    params: query
  })
}

// 查询未关联的商品属性列表
export function listNoAttrRelation(query) {
  return request({
    url: `/${service_name}/noAttrRelation`,
    method: 'get',
    params: query
  })
}

// 查询商品属性详细
export function getAttr(attrId) {
  return request({
    url: `/${service_name}/` + attrId,
    method: 'get'
  })
}

// 新增商品属性
export function addAttr(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改商品属性
export function updateAttr(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除商品属性
export function delAttr(attrId) {
  return request({
    url: `/${service_name}/` + attrId,
    method: 'delete'
  })
}
