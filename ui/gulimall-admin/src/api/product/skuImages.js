import request from '@/utils/request'

const service_name = 'product/skuImages';

// 查询sku图片列表
export function listSkuImages(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询sku图片详细
export function getSkuImages(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增sku图片
export function addSkuImages(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改sku图片
export function updateSkuImages(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除sku图片
export function delSkuImages(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
