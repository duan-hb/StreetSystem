import request from '@/utils/request'

// 查询店铺信息管理列表
export function listMerchants(query) {
  return request({
    url: '/merchants/merchants/list',
    method: 'get',
    params: query
  })
}

// 查询店铺信息管理详细
export function getMerchants(id) {
  return request({
    url: '/merchants/merchants/' + id,
    method: 'get'
  })
}

// 新增店铺信息管理
export function addMerchants(data) {
  return request({
    url: '/merchants/merchants',
    method: 'post',
    data: data
  })
}

// 修改店铺信息管理
export function updateMerchants(data) {
  return request({
    url: '/merchants/merchants',
    method: 'put',
    data: data
  })
}

// 删除店铺信息管理
export function delMerchants(id) {
  return request({
    url: '/merchants/merchants/' + id,
    method: 'delete'
  })
}
