import request from '@/utils/request'

const service_name = 'product/categoryBrandRelation';

// 查询品牌分类关联列表
export function listCategoryBrandRelation(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询品牌分类关联详细
export function getCategoryBrandRelation(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增品牌分类关联
export function addCategoryBrandRelation(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改品牌分类关联
export function updateCategoryBrandRelation(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除品牌分类关联
export function delCategoryBrandRelation(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
