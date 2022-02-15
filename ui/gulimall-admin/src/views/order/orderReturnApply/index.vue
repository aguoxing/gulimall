<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="order_id" prop="orderId">
        <el-input
          v-model="queryParams.orderId"
          placeholder="请输入order_id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="退货商品id" prop="skuId">
        <el-input
          v-model="queryParams.skuId"
          placeholder="请输入退货商品id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单编号" prop="orderSn">
        <el-input
          v-model="queryParams.orderSn"
          placeholder="请输入订单编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="会员用户名" prop="memberUsername">
        <el-input
          v-model="queryParams.memberUsername"
          placeholder="请输入会员用户名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="退款金额" prop="returnAmount">
        <el-input
          v-model="queryParams.returnAmount"
          placeholder="请输入退款金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="退货人姓名" prop="returnName">
        <el-input
          v-model="queryParams.returnName"
          placeholder="请输入退货人姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="退货人电话" prop="returnPhone">
        <el-input
          v-model="queryParams.returnPhone"
          placeholder="请输入退货人电话"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="处理时间" prop="handleTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.handleTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择处理时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="商品名称" prop="skuName">
        <el-input
          v-model="queryParams.skuName"
          placeholder="请输入商品名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品品牌" prop="skuBrand">
        <el-input
          v-model="queryParams.skuBrand"
          placeholder="请输入商品品牌"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="退货数量" prop="skuCount">
        <el-input
          v-model="queryParams.skuCount"
          placeholder="请输入退货数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品单价" prop="skuPrice">
        <el-input
          v-model="queryParams.skuPrice"
          placeholder="请输入商品单价"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品实际支付单价" prop="skuRealPrice">
        <el-input
          v-model="queryParams.skuRealPrice"
          placeholder="请输入商品实际支付单价"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="原因" prop="reason">
        <el-input
          v-model="queryParams.reason"
          placeholder="请输入原因"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="处理人员" prop="handleMan">
        <el-input
          v-model="queryParams.handleMan"
          placeholder="请输入处理人员"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收货人" prop="receiveMan">
        <el-input
          v-model="queryParams.receiveMan"
          placeholder="请输入收货人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收货时间" prop="receiveTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.receiveTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择收货时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="收货电话" prop="receivePhone">
        <el-input
          v-model="queryParams.receivePhone"
          placeholder="请输入收货电话"
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
          v-hasPermi="['order:orderReturnApply:add']"
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
          v-hasPermi="['order:orderReturnApply:edit']"
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
          v-hasPermi="['order:orderReturnApply:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['order:orderReturnApply:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="orderReturnApplyList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="order_id" align="center" prop="orderId" />
      <el-table-column label="退货商品id" align="center" prop="skuId" />
      <el-table-column label="订单编号" align="center" prop="orderSn" />
      <el-table-column label="会员用户名" align="center" prop="memberUsername" />
      <el-table-column label="退款金额" align="center" prop="returnAmount" />
      <el-table-column label="退货人姓名" align="center" prop="returnName" />
      <el-table-column label="退货人电话" align="center" prop="returnPhone" />
      <el-table-column label="申请状态[0-&gt;待处理；1-&gt;退货中；2-&gt;已完成；3-&gt;已拒绝]" align="center" prop="status" />
      <el-table-column label="处理时间" align="center" prop="handleTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.handleTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="商品图片" align="center" prop="skuImg" />
      <el-table-column label="商品名称" align="center" prop="skuName" />
      <el-table-column label="商品品牌" align="center" prop="skuBrand" />
      <el-table-column label="商品销售属性(JSON)" align="center" prop="skuAttrsVals" />
      <el-table-column label="退货数量" align="center" prop="skuCount" />
      <el-table-column label="商品单价" align="center" prop="skuPrice" />
      <el-table-column label="商品实际支付单价" align="center" prop="skuRealPrice" />
      <el-table-column label="原因" align="center" prop="reason" />
      <el-table-column label="描述" align="center" prop="description述" />
      <el-table-column label="凭证图片，以逗号隔开" align="center" prop="descPics" />
      <el-table-column label="处理备注" align="center" prop="handleNote" />
      <el-table-column label="处理人员" align="center" prop="handleMan" />
      <el-table-column label="收货人" align="center" prop="receiveMan" />
      <el-table-column label="收货时间" align="center" prop="receiveTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.receiveTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="收货备注" align="center" prop="receiveNote" />
      <el-table-column label="收货电话" align="center" prop="receivePhone" />
      <el-table-column label="公司收货地址" align="center" prop="companyAddress" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['order:orderReturnApply:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['order:orderReturnApply:remove']"
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

    <!-- 添加或修改订单退货申请对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="order_id" prop="orderId">
          <el-input v-model="form.orderId" placeholder="请输入order_id" />
        </el-form-item>
        <el-form-item label="退货商品id" prop="skuId">
          <el-input v-model="form.skuId" placeholder="请输入退货商品id" />
        </el-form-item>
        <el-form-item label="订单编号" prop="orderSn">
          <el-input v-model="form.orderSn" placeholder="请输入订单编号" />
        </el-form-item>
        <el-form-item label="会员用户名" prop="memberUsername">
          <el-input v-model="form.memberUsername" placeholder="请输入会员用户名" />
        </el-form-item>
        <el-form-item label="退款金额" prop="returnAmount">
          <el-input v-model="form.returnAmount" placeholder="请输入退款金额" />
        </el-form-item>
        <el-form-item label="退货人姓名" prop="returnName">
          <el-input v-model="form.returnName" placeholder="请输入退货人姓名" />
        </el-form-item>
        <el-form-item label="退货人电话" prop="returnPhone">
          <el-input v-model="form.returnPhone" placeholder="请输入退货人电话" />
        </el-form-item>
        <el-form-item label="处理时间" prop="handleTime">
          <el-date-picker clearable size="small"
            v-model="form.handleTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择处理时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="商品图片" prop="skuImg">
          <el-input v-model="form.skuImg" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="商品名称" prop="skuName">
          <el-input v-model="form.skuName" placeholder="请输入商品名称" />
        </el-form-item>
        <el-form-item label="商品品牌" prop="skuBrand">
          <el-input v-model="form.skuBrand" placeholder="请输入商品品牌" />
        </el-form-item>
        <el-form-item label="商品销售属性(JSON)" prop="skuAttrsVals">
          <el-input v-model="form.skuAttrsVals" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="退货数量" prop="skuCount">
          <el-input v-model="form.skuCount" placeholder="请输入退货数量" />
        </el-form-item>
        <el-form-item label="商品单价" prop="skuPrice">
          <el-input v-model="form.skuPrice" placeholder="请输入商品单价" />
        </el-form-item>
        <el-form-item label="商品实际支付单价" prop="skuRealPrice">
          <el-input v-model="form.skuRealPrice" placeholder="请输入商品实际支付单价" />
        </el-form-item>
        <el-form-item label="原因" prop="reason">
          <el-input v-model="form.reason" placeholder="请输入原因" />
        </el-form-item>
        <el-form-item label="描述" prop="description述">
          <el-input v-model="form.description述" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="凭证图片，以逗号隔开" prop="descPics">
          <el-input v-model="form.descPics" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="处理备注" prop="handleNote">
          <el-input v-model="form.handleNote" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="处理人员" prop="handleMan">
          <el-input v-model="form.handleMan" placeholder="请输入处理人员" />
        </el-form-item>
        <el-form-item label="收货人" prop="receiveMan">
          <el-input v-model="form.receiveMan" placeholder="请输入收货人" />
        </el-form-item>
        <el-form-item label="收货时间" prop="receiveTime">
          <el-date-picker clearable size="small"
            v-model="form.receiveTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择收货时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="收货备注" prop="receiveNote">
          <el-input v-model="form.receiveNote" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="收货电话" prop="receivePhone">
          <el-input v-model="form.receivePhone" placeholder="请输入收货电话" />
        </el-form-item>
        <el-form-item label="公司收货地址" prop="companyAddress">
          <el-input v-model="form.companyAddress" type="textarea" placeholder="请输入内容" />
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
import { listOrderReturnApply, getOrderReturnApply, delOrderReturnApply, addOrderReturnApply, updateOrderReturnApply } from "@/api/order/orderReturnApply";

export default {
  name: "OrderReturnApply",
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
      // 订单退货申请表格数据
      orderReturnApplyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderId: null,
        skuId: null,
        orderSn: null,
        memberUsername: null,
        returnAmount: null,
        returnName: null,
        returnPhone: null,
        status: null,
        handleTime: null,
        skuImg: null,
        skuName: null,
        skuBrand: null,
        skuAttrsVals: null,
        skuCount: null,
        skuPrice: null,
        skuRealPrice: null,
        reason: null,
        description述: null,
        descPics: null,
        handleNote: null,
        handleMan: null,
        receiveMan: null,
        receiveTime: null,
        receiveNote: null,
        receivePhone: null,
        companyAddress: null
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
    /** 查询订单退货申请列表 */
    getList() {
      this.loading = true;
      listOrderReturnApply(this.queryParams).then(response => {
        this.orderReturnApplyList = response.rows;
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
        orderId: null,
        skuId: null,
        orderSn: null,
        createTime: null,
        memberUsername: null,
        returnAmount: null,
        returnName: null,
        returnPhone: null,
        status: 0,
        handleTime: null,
        skuImg: null,
        skuName: null,
        skuBrand: null,
        skuAttrsVals: null,
        skuCount: null,
        skuPrice: null,
        skuRealPrice: null,
        reason: null,
        description述: null,
        descPics: null,
        handleNote: null,
        handleMan: null,
        receiveMan: null,
        receiveTime: null,
        receiveNote: null,
        receivePhone: null,
        companyAddress: null
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
      this.title = "添加订单退货申请";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOrderReturnApply(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改订单退货申请";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateOrderReturnApply(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOrderReturnApply(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除订单退货申请编号为"' + ids + '"的数据项？').then(function() {
        return delOrderReturnApply(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('order/orderReturnApply/export', {
        ...this.queryParams
      }, `orderReturnApply_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
