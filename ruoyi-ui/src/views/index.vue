<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>物业管理系统</title>
  <script src="https://cdn.jsdelivr.net/npm/vue@2"></script>
  <style>
    body {
      font-family: Arial, sans-serif;
    }
    .container {
      max-width: 800px;
      margin: 0 auto;
      padding: 20px;
    }
    .header {
      text-align: center;
      margin-bottom: 20px;
    }
    .info-statistics {
      display: flex;
      justify-content: space-between;
      margin-bottom: 20px;
    }
    .info-box {
      border: 1px solid #ccc;
      padding: 10px;
      width: 45%;
    }
    .activities, .complaints, .maintenance, .parking-lots, .system-info {
      margin-bottom: 20px;
    }
    table {
      width: 100%;
      border-collapse: collapse;
    }
    th, td {
      border: 1px solid #ccc;
      padding: 8px;
      text-align: left;
    }
  </style>
</head>
<body>
<div id="app" class="container">
  <div class="header">
    <h1>欢迎使用小区物业管理系统！v1.0</h1>
    <p>登录次数：{{ loginCount }}</p>
  </div>
  <div class="info-statistics">
    <div class="info-box">
      <h2>基本信息</h2>
      <p>总栋数：{{ totalBuildings }}</p>
      <p>总户数：{{ totalHouseholds }}</p>
      <p>总人数：{{ totalPeople }}</p>
      <p>租户数量：{{ tenants }}</p>
    </div>
    <div class="info-box">
      <h2>系统状态</h2>
      <!-- 这里可以添加更多系统状态信息 -->
    </div>
  </div>
  <div class="activities">
    <h2>最新活动</h2>
    <table>
      <tr v-for="activity in activities" :key="activity.id">
        <td>{{ activity.time }}</td>
        <td>{{ activity.name }}</td>
      </tr>
    </table>
  </div>
  <div class="complaints">
    <h2>投诉/满意度</h2>
    <!-- 这里可以添加投诉和满意度信息 -->
  </div>
  <div class="maintenance">
    <h2>最新保修</h2>
    <table>
      <tr v-for="maintenance in maintenanceList" :key="maintenance.id">
        <td>{{ maintenance.name }}</td>
        <td>{{ maintenance.status }}</td>
        <td>{{ maintenance.time }}</td>
      </tr>
    </table>
  </div>
  <div class="parking-lots">
    <h2>小区停车位</h2>
    <ul>
      <li v-for="lot in parkingLots" :key="lot">{{ lot }}</li>
    </ul>
  </div>
  <div class="system-info">
    <h2>系统信息</h2>
    <table>
      <tr v-for="(value, key) in systemInfo" :key="key">
        <td>{{ key }}</td>
        <td>{{ value }}</td>
      </tr>
    </table>
  </div>
</div>

<script>
  new Vue({
    el: '#app',
    data() {
      return {
        loginCount: 520, // 预填数据
        totalBuildings: 45, // 预填数据
        totalHouseholds: 600, // 预填数据
        totalPeople: 8310, // 预填数据
        tenants: 1314, // 预填数据
        activities: [ // 预填数据
          { id: 1, time: '09:00', name: '小区活动1' },
          { id: 2, time: '10:16', name: '小区活动2' },
          { id: 3, time: '08:22', name: '小区活动3' },
          { id: 4, time: '11:06', name: '小区活动4' },
          { id: 5, time: '12:00', name: '小区活动5' },
          { id: 6, time: '08:22', name: '小区活动6' },
          { id: 7, time: '11:06', name: '小区活动7' },
          { id: 8, time: '12:00', name: '小区活动8' },
          { id: 9, time: '11:06', name: '小区活动9' }
        ],
        maintenanceList: [ // 预填数据
          { id: 1, name: 'D区垃圾桶更换', status: '已受理', time: '09:00' },
          { id: 2, name: 'C区路灯维修', status: '已受理', time: '10:16' },
          { id: 3, name: 'A区13楼摄像头维修', status: '已受理', time: '08:22' },
          { id: 4, name: 'A区13楼摄像头维修', status: '已受理', time: '11:06' },
          { id: 5, name: 'A区13楼摄像头维修', status: '未受理', time: '12:00' },
          { id: 6, name: 'A区13楼摄像头维修', status: '未受理', time: '08:22' },
          { id: 7, name: 'A区13楼摄像头维修', status: '未受理', time: '11:06' },
          { id: 8, name: 'A区13楼摄像头维修', status: '已受理', time: '12:00' },
          { id: 9, name: 'A区13楼摄像头维修', status: '已受理', time: '11:06' }
        ],
        parkingLots: ['A区车位', 'B区车位', 'C区车位', 'D区车位', 'E区车位'], // 预填数据
        systemInfo: { // 预填数据
          '服务器计算机名': 'http://127.0.0.1/',
          '服务器IP地址': '192.168.1.1',
          '服务器域名': 'www.xxx.net',
          '服务器端口': '80',
          '服务器IIS版本': 'Microsoft-IIS/6.0',
          '本文件所在文件夹': 'D:\\WebSite',
          '服务器操作系统': 'Microsoft Windows NT 5.2.3790 Service Pack 2',
          '系统所在文件夹': 'C:WINDOWSIsystem32',
          '服务器脚本超时间': '30000秒 **自助打印**'
        }
      };
    },
    methods: {
      // 在这里可以定义一些方法来处理数据交互等操作
    }
  });
</script>
</body>
</html>
