import request from '@/utils/request'

const service_name = 'product/category';

// 查询商品三级分类列表
export function listCategory(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询商品三级分类详细
export function getCategory(catId) {
  return request({
    url: `/${service_name}/` + catId,
    method: 'get'
  })
}

// 新增商品三级分类
export function addCategory(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改商品三级分类
export function updateCategory(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除商品三级分类
export function delCategory(catId) {
  return request({
    url: `/${service_name}/` + catId,
    method: 'delete'
  })
}
