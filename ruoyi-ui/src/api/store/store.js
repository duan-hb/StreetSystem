import request from '@/utils/request'

// 查询店铺管理列表
export function listStore(query) {
  return request({
    url: '/store/store/list',
    method: 'get',
    params: query
  })
}

export function getStoreType() {
  return request({
    url: '/store/store/type',
    method: 'get'
  })
}

// 查询店铺管理详细
export function getStore(id) {
  return request({
    url: '/store/store/' + id,
    method: 'get'
  })
}

// 新增店铺管理
export function addStore(data) {
  return request({
    url: '/store/store',
    method: 'post',
    data: data
  })
}

// 修改店铺管理
export function updateStore(data) {
  return request({
    url: '/store/store',
    method: 'put',
    data: data
  })
}

// 删除店铺管理
export function delStore(id) {
  return request({
    url: '/store/store/' + id,
    method: 'delete'
  })
}
