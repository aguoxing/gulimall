import request from '@/utils/request'

const service_name = 'product/productAttrValue';

// 查询spu属性值列表
export function listProductAttrValue(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询spu属性值详细
export function getProductAttrValue(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增spu属性值
export function addProductAttrValue(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改spu属性值
export function updateProductAttrValue(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除spu属性值
export function delProductAttrValue(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
