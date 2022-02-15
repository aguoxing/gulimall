import request from '@/utils/request'

const service_name = 'product/spuImages';

// 查询spu图片列表
export function listSpuImages(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询spu图片详细
export function getSpuImages(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增spu图片
export function addSpuImages(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改spu图片
export function updateSpuImages(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除spu图片
export function delSpuImages(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
