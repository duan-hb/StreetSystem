<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商铺名称" prop="shopName">
        <el-input
          v-model="queryParams.shopName"
          placeholder="请输入商铺名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="投诉人员" prop="complaintName">
        <el-input
          v-model="queryParams.complaintName"
          placeholder="请输入投诉人员"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="投诉时间">
        <el-date-picker
          v-model="daterangeCreatTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['complaints:complaints:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['complaints:complaints:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['complaints:complaints:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['complaints:complaints:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="complaintsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="投诉ID" align="center" prop="id" />
      <el-table-column label="商铺名称" align="center" prop="shopName" />
      <el-table-column label="投诉人员" align="center" prop="complaintName" />
      <el-table-column label="投诉人电话(可选)" align="center" prop="complainantPhone" />
      <el-table-column label="投诉类型" align="center" prop="complaintType" />
      <el-table-column label="投诉时间" align="center" prop="creatTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.creatTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="投诉事由" align="center" prop="description" />
      <el-table-column label="投诉状态" align="center" prop="status" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['complaints:complaints:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['complaints:complaints:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改用户投诉对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="被店铺id" prop="storeId">
          <el-input v-model="form.storeId" placeholder="请输入被店铺id" />
        </el-form-item>
        <el-form-item label="商铺名称" prop="shopName">
          <el-input v-model="form.shopName" placeholder="请输入商铺名称" />
        </el-form-item>
        <el-form-item label="投诉用户id" prop="complaintId">
          <el-input v-model="form.complaintId" placeholder="请输入投诉用户id" />
        </el-form-item>
        <el-form-item label="投诉人员" prop="complaintName">
          <el-input v-model="form.complaintName" placeholder="请输入投诉人员" />
        </el-form-item>
        <el-form-item label="投诉人电话(可选)" prop="complainantPhone">
          <el-input v-model="form.complainantPhone" placeholder="请输入投诉人电话(可选)" />
        </el-form-item>
        <el-form-item label="投诉时间" prop="creatTime">
          <el-date-picker clearable
                          v-model="form.creatTime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择投诉时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="投诉事由" prop="description">
          <el-input v-model="form.description" placeholder="请输入投诉事由" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listComplaints, getComplaints, delComplaints, addComplaints, updateComplaints } from "@/api/complaints/complaints";

export default {
  name: "Complaints",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 用户投诉表格数据
      complaintsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 投诉状态时间范围
      daterangeCreatTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        shopName: null,
        complaintName: null,
        complaintType: null,
        creatTime: null,
        status: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        shopName: [
          { required: true, message: "商铺名称不能为空", trigger: "blur" }
        ],
        complaintType: [
          { required: true, message: "投诉类型不能为空", trigger: "change" }
        ],
        creatTime: [
          { required: true, message: "投诉时间不能为空", trigger: "blur" }
        ],
        description: [
          { required: true, message: "投诉事由不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询用户投诉列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeCreatTime && '' != this.daterangeCreatTime) {
        this.queryParams.params["beginCreatTime"] = this.daterangeCreatTime[0];
        this.queryParams.params["endCreatTime"] = this.daterangeCreatTime[1];
      }
      listComplaints(this.queryParams).then(response => {
        this.complaintsList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        storeId: null,
        shopName: null,
        complaintId: null,
        complaintName: null,
        complainantPhone: null,
        complaintType: null,
        creatTime: null,
        description: null,
        status: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.daterangeCreatTime = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加用户投诉";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getComplaints(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户投诉";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateComplaints(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addComplaints(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除用户投诉编号为"' + ids + '"的数据项？').then(function() {
        return delComplaints(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('complaints/complaints/export', {
        ...this.queryParams
      }, `complaints_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

