<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="退款的订单" prop="orderReturnId">
        <el-input
          v-model="queryParams.orderReturnId"
          placeholder="请输入退款的订单"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="退款金额" prop="refund">
        <el-input
          v-model="queryParams.refund"
          placeholder="请输入退款金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="退款交易流水号" prop="refundSn">
        <el-input
          v-model="queryParams.refundSn"
          placeholder="请输入退款交易流水号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="退款渠道[1-支付宝，2-微信，3-银联，4-汇款]" prop="refundChannel">
        <el-input
          v-model="queryParams.refundChannel"
          placeholder="请输入退款渠道[1-支付宝，2-微信，3-银联，4-汇款]"
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
          v-hasPermi="['order:refundInfo:add']"
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
          v-hasPermi="['order:refundInfo:edit']"
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
          v-hasPermi="['order:refundInfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['order:refundInfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="refundInfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="退款的订单" align="center" prop="orderReturnId" />
      <el-table-column label="退款金额" align="center" prop="refund" />
      <el-table-column label="退款交易流水号" align="center" prop="refundSn" />
      <el-table-column label="退款状态" align="center" prop="refundStatus" />
      <el-table-column label="退款渠道[1-支付宝，2-微信，3-银联，4-汇款]" align="center" prop="refundChannel" />
      <el-table-column label="${comment}" align="center" prop="refundContent" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['order:refundInfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['order:refundInfo:remove']"
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

    <!-- 添加或修改退款信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="退款的订单" prop="orderReturnId">
          <el-input v-model="form.orderReturnId" placeholder="请输入退款的订单" />
        </el-form-item>
        <el-form-item label="退款金额" prop="refund">
          <el-input v-model="form.refund" placeholder="请输入退款金额" />
        </el-form-item>
        <el-form-item label="退款交易流水号" prop="refundSn">
          <el-input v-model="form.refundSn" placeholder="请输入退款交易流水号" />
        </el-form-item>
        <el-form-item label="退款渠道[1-支付宝，2-微信，3-银联，4-汇款]" prop="refundChannel">
          <el-input v-model="form.refundChannel" placeholder="请输入退款渠道[1-支付宝，2-微信，3-银联，4-汇款]" />
        </el-form-item>
        <el-form-item label="${comment}">
          <editor v-model="form.refundContent" :min-height="192"/>
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
import { listRefundInfo, getRefundInfo, delRefundInfo, addRefundInfo, updateRefundInfo } from "@/api/order/refundInfo";

export default {
  name: "RefundInfo",
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
      // 退款信息表格数据
      refundInfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderReturnId: null,
        refund: null,
        refundSn: null,
        refundStatus: null,
        refundChannel: null,
        refundContent: null
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
    /** 查询退款信息列表 */
    getList() {
      this.loading = true;
      listRefundInfo(this.queryParams).then(response => {
        this.refundInfoList = response.rows;
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
        orderReturnId: null,
        refund: null,
        refundSn: null,
        refundStatus: 0,
        refundChannel: null,
        refundContent: null
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
      this.title = "添加退款信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getRefundInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改退款信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateRefundInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRefundInfo(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除退款信息编号为"' + ids + '"的数据项？').then(function() {
        return delRefundInfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('order/refundInfo/export', {
        ...this.queryParams
      }, `refundInfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
