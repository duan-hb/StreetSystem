import request from '@/utils/request'

// 查询管理员信息管理列表
export function listManager(query) {
  return request({
    url: '/manager/manager/list',
    method: 'get',
    params: query
  })
}

// 查询管理员信息管理详细
export function getManager(id) {
  return request({
    url: '/manager/manager/' + id,
    method: 'get'
  })
}

// 新增管理员信息管理
export function addManager(data) {
  return request({
    url: '/manager/manager',
    method: 'post',
    data: data
  })
}

// 修改管理员信息管理
export function updateManager(data) {
  return request({
    url: '/manager/manager',
    method: 'put',
    data: data
  })
}

// 删除管理员信息管理
export function delManager(id) {
  return request({
    url: '/manager/manager/' + id,
    method: 'delete'
  })
}
