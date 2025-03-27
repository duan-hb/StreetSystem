import request from '@/utils/request'

// 查询用户投诉列表
export function listComplaints(query) {
  return request({
    url: '/complaints/complaints/list',
    method: 'get',
    params: query
  })
}

// 查询用户投诉详细
export function getComplaints(id) {
  return request({
    url: '/complaints/complaints/' + id,
    method: 'get'
  })
}

// 新增用户投诉
export function addComplaints(data) {
  return request({
    url: '/complaints/complaints',
    method: 'post',
    data: data
  })
}

// 修改用户投诉
export function updateComplaints(data) {
  return request({
    url: '/complaints/complaints',
    method: 'put',
    data: data
  })
}

// 删除用户投诉
export function delComplaints(id) {
  return request({
    url: '/complaints/complaints/' + id,
    method: 'delete'
  })
}
