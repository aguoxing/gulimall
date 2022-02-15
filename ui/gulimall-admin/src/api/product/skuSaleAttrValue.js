import request from '@/utils/request'

const service_name = 'product/skuSaleAttrValue';

// 查询sku销售属性&值列表
export function listSkuSaleAttrValue(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询sku销售属性&值详细
export function getSkuSaleAttrValue(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增sku销售属性&值
export function addSkuSaleAttrValue(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改sku销售属性&值
export function updateSkuSaleAttrValue(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除sku销售属性&值
export function delSkuSaleAttrValue(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
