<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="秒杀订单超时关闭时间(分)" prop="flashOrderOvertime">
        <el-input
          v-model="queryParams.flashOrderOvertime"
          placeholder="请输入秒杀订单超时关闭时间(分)"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="正常订单超时时间(分)" prop="normalOrderOvertime">
        <el-input
          v-model="queryParams.normalOrderOvertime"
          placeholder="请输入正常订单超时时间(分)"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发货后自动确认收货时间" prop="confirmOvertime">
        <el-input
          v-model="queryParams.confirmOvertime"
          placeholder="请输入发货后自动确认收货时间"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="自动完成交易时间，不能申请退货" prop="finishOvertime">
        <el-input
          v-model="queryParams.finishOvertime"
          placeholder="请输入自动完成交易时间，不能申请退货"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单完成后自动好评时间" prop="commentOvertime">
        <el-input
          v-model="queryParams.commentOvertime"
          placeholder="请输入订单完成后自动好评时间"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】" prop="memberLevel">
        <el-input
          v-model="queryParams.memberLevel"
          placeholder="请输入会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】"
          clearable
          size="small"
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
          v-hasPermi="['order:orderSetting:add']"
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
          v-hasPermi="['order:orderSetting:edit']"
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
          v-hasPermi="['order:orderSetting:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['order:orderSetting:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="orderSettingList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="秒杀订单超时关闭时间(分)" align="center" prop="flashOrderOvertime" />
      <el-table-column label="正常订单超时时间(分)" align="center" prop="normalOrderOvertime" />
      <el-table-column label="发货后自动确认收货时间" align="center" prop="confirmOvertime" />
      <el-table-column label="自动完成交易时间，不能申请退货" align="center" prop="finishOvertime" />
      <el-table-column label="订单完成后自动好评时间" align="center" prop="commentOvertime" />
      <el-table-column label="会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】" align="center" prop="memberLevel" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['order:orderSetting:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['order:orderSetting:remove']"
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

    <!-- 添加或修改订单配置信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="秒杀订单超时关闭时间(分)" prop="flashOrderOvertime">
          <el-input v-model="form.flashOrderOvertime" placeholder="请输入秒杀订单超时关闭时间(分)" />
        </el-form-item>
        <el-form-item label="正常订单超时时间(分)" prop="normalOrderOvertime">
          <el-input v-model="form.normalOrderOvertime" placeholder="请输入正常订单超时时间(分)" />
        </el-form-item>
        <el-form-item label="发货后自动确认收货时间" prop="confirmOvertime">
          <el-input v-model="form.confirmOvertime" placeholder="请输入发货后自动确认收货时间" />
        </el-form-item>
        <el-form-item label="自动完成交易时间，不能申请退货" prop="finishOvertime">
          <el-input v-model="form.finishOvertime" placeholder="请输入自动完成交易时间，不能申请退货" />
        </el-form-item>
        <el-form-item label="订单完成后自动好评时间" prop="commentOvertime">
          <el-input v-model="form.commentOvertime" placeholder="请输入订单完成后自动好评时间" />
        </el-form-item>
        <el-form-item label="会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】" prop="memberLevel">
          <el-input v-model="form.memberLevel" placeholder="请输入会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】" />
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
import { listOrderSetting, getOrderSetting, delOrderSetting, addOrderSetting, updateOrderSetting } from "@/api/order/orderSetting";

export default {
  name: "OrderSetting",
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
      // 订单配置信息表格数据
      orderSettingList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        flashOrderOvertime: null,
        normalOrderOvertime: null,
        confirmOvertime: null,
        finishOvertime: null,
        commentOvertime: null,
        memberLevel: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询订单配置信息列表 */
    getList() {
      this.loading = true;
      listOrderSetting(this.queryParams).then(response => {
        this.orderSettingList = response.rows;
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
        flashOrderOvertime: null,
        normalOrderOvertime: null,
        confirmOvertime: null,
        finishOvertime: null,
        commentOvertime: null,
        memberLevel: null
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
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加订单配置信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOrderSetting(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改订单配置信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateOrderSetting(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOrderSetting(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除订单配置信息编号为"' + ids + '"的数据项？').then(function() {
        return delOrderSetting(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('order/orderSetting/export', {
        ...this.queryParams
      }, `orderSetting_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
