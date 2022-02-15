import request from '@/utils/request'

const service_name = 'product/attrAttrgroupRelation';

// 查询属性&属性分组关联列表
export function listAttrAttrgroupRelation(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询属性&属性分组关联详细
export function getAttrAttrgroupRelation(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增属性&属性分组关联
export function addAttrAttrgroupRelation(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改属性&属性分组关联
export function updateAttrAttrgroupRelation(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除属性&属性分组关联
export function delAttrAttrgroupRelation(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
