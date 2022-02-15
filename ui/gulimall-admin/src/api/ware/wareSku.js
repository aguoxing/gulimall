import request from '@/utils/request'

const service_name = 'ware/wareSku';

// 查询商品库存列表
export function listWareSku(query) {
  return request({
    url: `/${service_name}/list`,
    method: 'get',
    params: query
  })
}

// 查询商品库存详细
export function getWareSku(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'get'
  })
}

// 新增商品库存
export function addWareSku(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 修改商品库存
export function updateWareSku(data) {
  return request({
    url: `/${service_name}`,
    method: 'put',
    data: data
  })
}

// 删除商品库存
export function delWareSku(id) {
  return request({
    url: `/${service_name}/` + id,
    method: 'delete'
  })
}
