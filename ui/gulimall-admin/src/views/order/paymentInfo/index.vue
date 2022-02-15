<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="订单号" prop="orderSn">
        <el-input
          v-model="queryParams.orderSn"
          placeholder="请输入订单号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单id" prop="orderId">
        <el-input
          v-model="queryParams.orderId"
          placeholder="请输入订单id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="支付宝交易流水号" prop="alipayTradeNo">
        <el-input
          v-model="queryParams.alipayTradeNo"
          placeholder="请输入支付宝交易流水号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="支付总金额" prop="totalAmount">
        <el-input
          v-model="queryParams.totalAmount"
          placeholder="请输入支付总金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="交易内容" prop="subject">
        <el-input
          v-model="queryParams.subject"
          placeholder="请输入交易内容"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="确认时间" prop="confirmTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.confirmTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择确认时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="回调时间" prop="callbackTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.callbackTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择回调时间">
        </el-date-picker>
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
          v-hasPermi="['order:paymentInfo:add']"
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
          v-hasPermi="['order:paymentInfo:edit']"
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
          v-hasPermi="['order:paymentInfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['order:paymentInfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="paymentInfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="订单号" align="center" prop="orderSn" />
      <el-table-column label="订单id" align="center" prop="orderId" />
      <el-table-column label="支付宝交易流水号" align="center" prop="alipayTradeNo" />
      <el-table-column label="支付总金额" align="center" prop="totalAmount" />
      <el-table-column label="交易内容" align="center" prop="subject" />
      <el-table-column label="支付状态" align="center" prop="paymentStatus" />
      <el-table-column label="确认时间" align="center" prop="confirmTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.confirmTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="回调内容" align="center" prop="callbackContent" />
      <el-table-column label="回调时间" align="center" prop="callbackTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.callbackTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['order:paymentInfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['order:paymentInfo:remove']"
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

    <!-- 添加或修改支付信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="订单号" prop="orderSn">
          <el-input v-model="form.orderSn" placeholder="请输入订单号" />
        </el-form-item>
        <el-form-item label="订单id" prop="orderId">
          <el-input v-model="form.orderId" placeholder="请输入订单id" />
        </el-form-item>
        <el-form-item label="支付宝交易流水号" prop="alipayTradeNo">
          <el-input v-model="form.alipayTradeNo" placeholder="请输入支付宝交易流水号" />
        </el-form-item>
        <el-form-item label="支付总金额" prop="totalAmount">
          <el-input v-model="form.totalAmount" placeholder="请输入支付总金额" />
        </el-form-item>
        <el-form-item label="交易内容" prop="subject">
          <el-input v-model="form.subject" placeholder="请输入交易内容" />
        </el-form-item>
        <el-form-item label="确认时间" prop="confirmTime">
          <el-date-picker clearable size="small"
            v-model="form.confirmTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择确认时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="回调内容">
          <editor v-model="form.callbackContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="回调时间" prop="callbackTime">
          <el-date-picker clearable size="small"
            v-model="form.callbackTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择回调时间">
          </el-date-picker>
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
import { listPaymentInfo, getPaymentInfo, delPaymentInfo, addPaymentInfo, updatePaymentInfo } from "@/api/order/paymentInfo";

export default {
  name: "PaymentInfo",
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
      // 支付信息表格数据
      paymentInfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderSn: null,
        orderId: null,
        alipayTradeNo: null,
        totalAmount: null,
        subject: null,
        paymentStatus: null,
        confirmTime: null,
        callbackContent: null,
        callbackTime: null
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
    /** 查询支付信息列表 */
    getList() {
      this.loading = true;
      listPaymentInfo(this.queryParams).then(response => {
        this.paymentInfoList = response.rows;
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
        orderSn: null,
        orderId: null,
        alipayTradeNo: null,
        totalAmount: null,
        subject: null,
        paymentStatus: "0",
        createTime: null,
        confirmTime: null,
        callbackContent: null,
        callbackTime: null
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
      this.title = "添加支付信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPaymentInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改支付信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePaymentInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPaymentInfo(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除支付信息编号为"' + ids + '"的数据项？').then(function() {
        return delPaymentInfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('order/paymentInfo/export', {
        ...this.queryParams
      }, `paymentInfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
