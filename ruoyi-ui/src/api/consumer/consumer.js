import request from '@/utils/request'

// 查询消费者信息列表
export function listConsumer(query) {
  return request({
    url: '/consumer/consumer/list',
    method: 'get',
    params: query
  })
}

// 查询消费者信息详细
export function getConsumer(id) {
  return request({
    url: '/consumer/consumer/' + id,
    method: 'get'
  })
}

// 新增消费者信息
export function addConsumer(data) {
  return request({
    url: '/consumer/consumer',
    method: 'post',
    data: data
  })
}

// 修改消费者信息
export function updateConsumer(data) {
  return request({
    url: '/consumer/consumer',
    method: 'put',
    data: data
  })
}

// 删除消费者信息
export function delConsumer(id) {
  return request({
    url: '/consumer/consumer/' + id,
    method: 'delete'
  })
}
