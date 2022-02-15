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
      <el-form-item label="order_sn" prop="orderSn">
        <el-input
          v-model="queryParams.orderSn"
          placeholder="请输入order_sn"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="spu_id" prop="spuId">
        <el-input
          v-model="queryParams.spuId"
          placeholder="请输入spu_id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="spu_name" prop="spuName">
        <el-input
          v-model="queryParams.spuName"
          placeholder="请输入spu_name"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="品牌" prop="spuBrand">
        <el-input
          v-model="queryParams.spuBrand"
          placeholder="请输入品牌"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品分类id" prop="categoryId">
        <el-input
          v-model="queryParams.categoryId"
          placeholder="请输入商品分类id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品sku编号" prop="skuId">
        <el-input
          v-model="queryParams.skuId"
          placeholder="请输入商品sku编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品sku名字" prop="skuName">
        <el-input
          v-model="queryParams.skuName"
          placeholder="请输入商品sku名字"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品sku价格" prop="skuPrice">
        <el-input
          v-model="queryParams.skuPrice"
          placeholder="请输入商品sku价格"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品购买的数量" prop="skuQuantity">
        <el-input
          v-model="queryParams.skuQuantity"
          placeholder="请输入商品购买的数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品促销分解金额" prop="promotionAmount">
        <el-input
          v-model="queryParams.promotionAmount"
          placeholder="请输入商品促销分解金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="优惠券优惠分解金额" prop="couponAmount">
        <el-input
          v-model="queryParams.couponAmount"
          placeholder="请输入优惠券优惠分解金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="积分优惠分解金额" prop="integrationAmount">
        <el-input
          v-model="queryParams.integrationAmount"
          placeholder="请输入积分优惠分解金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="该商品经过优惠后的分解金额" prop="realAmount">
        <el-input
          v-model="queryParams.realAmount"
          placeholder="请输入该商品经过优惠后的分解金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="赠送积分" prop="giftIntegration">
        <el-input
          v-model="queryParams.giftIntegration"
          placeholder="请输入赠送积分"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="赠送成长值" prop="giftGrowth">
        <el-input
          v-model="queryParams.giftGrowth"
          placeholder="请输入赠送成长值"
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
          v-hasPermi="['order:orderItem:add']"
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
          v-hasPermi="['order:orderItem:edit']"
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
          v-hasPermi="['order:orderItem:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['order:orderItem:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="orderItemList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="order_id" align="center" prop="orderId" />
      <el-table-column label="order_sn" align="center" prop="orderSn" />
      <el-table-column label="spu_id" align="center" prop="spuId" />
      <el-table-column label="spu_name" align="center" prop="spuName" />
      <el-table-column label="spu_pic" align="center" prop="spuPic" />
      <el-table-column label="品牌" align="center" prop="spuBrand" />
      <el-table-column label="商品分类id" align="center" prop="categoryId" />
      <el-table-column label="商品sku编号" align="center" prop="skuId" />
      <el-table-column label="商品sku名字" align="center" prop="skuName" />
      <el-table-column label="商品sku图片" align="center" prop="skuPic" />
      <el-table-column label="商品sku价格" align="center" prop="skuPrice" />
      <el-table-column label="商品购买的数量" align="center" prop="skuQuantity" />
      <el-table-column label="商品销售属性组合" align="center" prop="skuAttrsVals" />
      <el-table-column label="商品促销分解金额" align="center" prop="promotionAmount" />
      <el-table-column label="优惠券优惠分解金额" align="center" prop="couponAmount" />
      <el-table-column label="积分优惠分解金额" align="center" prop="integrationAmount" />
      <el-table-column label="该商品经过优惠后的分解金额" align="center" prop="realAmount" />
      <el-table-column label="赠送积分" align="center" prop="giftIntegration" />
      <el-table-column label="赠送成长值" align="center" prop="giftGrowth" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['order:orderItem:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['order:orderItem:remove']"
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

    <!-- 添加或修改订单项信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="order_id" prop="orderId">
          <el-input v-model="form.orderId" placeholder="请输入order_id" />
        </el-form-item>
        <el-form-item label="order_sn" prop="orderSn">
          <el-input v-model="form.orderSn" placeholder="请输入order_sn" />
        </el-form-item>
        <el-form-item label="spu_id" prop="spuId">
          <el-input v-model="form.spuId" placeholder="请输入spu_id" />
        </el-form-item>
        <el-form-item label="spu_name" prop="spuName">
          <el-input v-model="form.spuName" placeholder="请输入spu_name" />
        </el-form-item>
        <el-form-item label="spu_pic" prop="spuPic">
          <el-input v-model="form.spuPic" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="品牌" prop="spuBrand">
          <el-input v-model="form.spuBrand" placeholder="请输入品牌" />
        </el-form-item>
        <el-form-item label="商品分类id" prop="categoryId">
          <el-input v-model="form.categoryId" placeholder="请输入商品分类id" />
        </el-form-item>
        <el-form-item label="商品sku编号" prop="skuId">
          <el-input v-model="form.skuId" placeholder="请输入商品sku编号" />
        </el-form-item>
        <el-form-item label="商品sku名字" prop="skuName">
          <el-input v-model="form.skuName" placeholder="请输入商品sku名字" />
        </el-form-item>
        <el-form-item label="商品sku图片" prop="skuPic">
          <el-input v-model="form.skuPic" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="商品sku价格" prop="skuPrice">
          <el-input v-model="form.skuPrice" placeholder="请输入商品sku价格" />
        </el-form-item>
        <el-form-item label="商品购买的数量" prop="skuQuantity">
          <el-input v-model="form.skuQuantity" placeholder="请输入商品购买的数量" />
        </el-form-item>
        <el-form-item label="商品销售属性组合" prop="skuAttrsVals">
          <el-input v-model="form.skuAttrsVals" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="商品促销分解金额" prop="promotionAmount">
          <el-input v-model="form.promotionAmount" placeholder="请输入商品促销分解金额" />
        </el-form-item>
        <el-form-item label="优惠券优惠分解金额" prop="couponAmount">
          <el-input v-model="form.couponAmount" placeholder="请输入优惠券优惠分解金额" />
        </el-form-item>
        <el-form-item label="积分优惠分解金额" prop="integrationAmount">
          <el-input v-model="form.integrationAmount" placeholder="请输入积分优惠分解金额" />
        </el-form-item>
        <el-form-item label="该商品经过优惠后的分解金额" prop="realAmount">
          <el-input v-model="form.realAmount" placeholder="请输入该商品经过优惠后的分解金额" />
        </el-form-item>
        <el-form-item label="赠送积分" prop="giftIntegration">
          <el-input v-model="form.giftIntegration" placeholder="请输入赠送积分" />
        </el-form-item>
        <el-form-item label="赠送成长值" prop="giftGrowth">
          <el-input v-model="form.giftGrowth" placeholder="请输入赠送成长值" />
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
import { listOrderItem, getOrderItem, delOrderItem, addOrderItem, updateOrderItem } from "@/api/order/orderItem";

export default {
  name: "OrderItem",
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
      // 订单项信息表格数据
      orderItemList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderId: null,
        orderSn: null,
        spuId: null,
        spuName: null,
        spuPic: null,
        spuBrand: null,
        categoryId: null,
        skuId: null,
        skuName: null,
        skuPic: null,
        skuPrice: null,
        skuQuantity: null,
        skuAttrsVals: null,
        promotionAmount: null,
        couponAmount: null,
        integrationAmount: null,
        realAmount: null,
        giftIntegration: null,
        giftGrowth: null
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
    /** 查询订单项信息列表 */
    getList() {
      this.loading = true;
      listOrderItem(this.queryParams).then(response => {
        this.orderItemList = response.rows;
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
        orderSn: null,
        spuId: null,
        spuName: null,
        spuPic: null,
        spuBrand: null,
        categoryId: null,
        skuId: null,
        skuName: null,
        skuPic: null,
        skuPrice: null,
        skuQuantity: null,
        skuAttrsVals: null,
        promotionAmount: null,
        couponAmount: null,
        integrationAmount: null,
        realAmount: null,
        giftIntegration: null,
        giftGrowth: null
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
      this.title = "添加订单项信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOrderItem(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改订单项信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateOrderItem(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOrderItem(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除订单项信息编号为"' + ids + '"的数据项？').then(function() {
        return delOrderItem(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('order/orderItem/export', {
        ...this.queryParams
      }, `orderItem_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
