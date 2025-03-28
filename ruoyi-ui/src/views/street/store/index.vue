<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商店名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入商店名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商店地址" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入商店地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['store:store:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['store:store:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['store:store:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['store:store:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="storeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="商店id" align="center" prop="id"/>
      <el-table-column label="商店名称" align="center" prop="name"/>
      <el-table-column label="商店地址" align="center" prop="address"/>
      <el-table-column label="店铺类型" align="center" prop="type"/>
      <el-table-column label="店铺状态" align="center" prop="status"/>
      <el-table-column label="持有人" align="center" prop="merchants.name"/>
      <el-table-column label="联系电话" align="center" prop="merchants.phone"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['store:store:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['store:store:remove']"
          >删除
          </el-button>
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

    <!-- 添加或修改店铺管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商店名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入商店名称"/>
        </el-form-item>
        <el-form-item label="商店地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入商店地址"/>
        </el-form-item>
        <el-form-item label="商店类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择商店类型">
            <el-option
              v-for="item in types"
              :key="item.id"
              :label="item.name"
              :value="item.name">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="持有人" prop="merchants">
          <el-select v-model="form.merchants.name" placeholder="请选择店铺持有人">
            <el-option
              v-for="item in merchants"
              :key="item.id"
              :label="item.name"
              :value="item.name">
            </el-option>
          </el-select>
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
import {listStore, getStore, delStore, addStore, updateStore, getStoreType} from "@/api/store/store";
import {listMerchants} from "../../../api/merchants/merchants";

export default {
  name: "Store",
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
      // 店铺管理表格数据
      storeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        address: null,
        type: null,
        status: null,
      },
      // 表单参数
      form: {
        merchants:{
          name:"张三"
        }
      },
      types: [],
      merchants: [],
      // 表单校验
      rules: {
      }
    }
      ;
  },
  created() {
    this.getList();
    this.getType();
    this.getMerchants();
  },
  methods: {
    /** 查询店铺管理列表 */
    getList() {
      this.loading = true;
      listStore(this.queryParams).then(response => {
        this.storeList = response.rows;//所有店铺信息s
        this.total = response.total;
        this.loading = false;
      });
    },
    getMerchants() {
      //商家信息
      listMerchants(this.queryParams).then(res => {
        this.merchants = res.rows;
      });
    },
    getType() {
      //查询店铺类型
      getStoreType().then(res => {
        this.types = res.data;
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
        name: null,
        address: null,
        type: null,
        status: null,
        merchants: " "
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
    this.resetForm("queryForm");
    this.handleQuery();
  },
  // 多选框选中数据
  handleSelectionChange(selection) {
    this.ids = selection.map(item => item.id)
    this.single = selection.length !== 1
    this.multiple = !selection.length
  },
  /** 新增按钮操作 */
  handleAdd() {
    this.reset();
    this.open = true;
    this.title = "添加店铺管理";
  },
  /** 修改按钮操作 */
  handleUpdate(row) {
    this.reset();
    this.form = row;
    this.open = true;
    this.title = "修改店铺管理";
    console.log("row");
    console.log(row);
    // const id = row.id || this.ids
    // getStore(id).then(response => {
    //   this.form = response.data;
    //   this.open = true;
    //   this.title = "修改店铺管理";
    // });
  },
  /** 提交按钮 */
  submitForm() {
    this.$refs["form"].validate(valid => {
      console.log("form")
      console.log(this.form);
      if (valid) {
        if (this.form.id != null) {
          updateStore(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
        } else {
          addStore(this.form).then(response => {
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
    this.$modal.confirm('是否确认删除编号为"' + ids + '"的店铺？').then(function () {
      return delStore(ids);
    }).then(() => {
      this.getList();
      this.$modal.msgSuccess("删除成功");
    }).catch(() => {
    });
  },
  /** 导出按钮操作 */
  handleExport() {
    this.download('store/store/export', {
      ...this.queryParams
    }, `store_${new Date().getTime()}.xlsx`)
  }
}
}
;
</script>

