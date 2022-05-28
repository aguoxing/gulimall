import request from '@/utils/request'

const service_name = 'product/attrGroupRelation';

// 新增属性&属性分组关联
export function addAttrGroupRelation(data) {
  return request({
    url: `/${service_name}`,
    method: 'post',
    data: data
  })
}

// 删除属性组关联
export function delRelationByAttrIds(data) {
  return request({
    url: `/${service_name}/delRelation`,
    method: 'post',
    data: data
  })
}
