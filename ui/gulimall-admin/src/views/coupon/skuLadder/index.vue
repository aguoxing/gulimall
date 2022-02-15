<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="spu_id" prop="skuId">
        <el-input
          v-model="queryParams.skuId"
          placeholder="请输入spu_id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="满几件" prop="fullCount">
        <el-input
          v-model="queryParams.fullCount"
          placeholder="请输入满几件"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="打几折" prop="discount">
        <el-input
          v-model="queryParams.discount"
          placeholder="请输入打几折"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="折后价" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入折后价"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否叠加其他优惠[0-不可叠加，1-可叠加]" prop="addOther">
        <el-input
          v-model="queryParams.addOther"
          placeholder="请输入是否叠加其他优惠[0-不可叠加，1-可叠加]"
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
          v-hasPermi="['coupon:skuLadder:add']"
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
          v-hasPermi="['coupon:skuLadder:edit']"
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
          v-hasPermi="['coupon:skuLadder:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['coupon:skuLadder:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="skuLadderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="spu_id" align="center" prop="skuId" />
      <el-table-column label="满几件" align="center" prop="fullCount" />
      <el-table-column label="打几折" align="center" prop="discount" />
      <el-table-column label="折后价" align="center" prop="price" />
      <el-table-column label="是否叠加其他优惠[0-不可叠加，1-可叠加]" align="center" prop="addOther" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['coupon:skuLadder:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['coupon:skuLadder:remove']"
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

    <!-- 添加或修改商品阶梯价格对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="spu_id" prop="skuId">
          <el-input v-model="form.skuId" placeholder="请输入spu_id" />
        </el-form-item>
        <el-form-item label="满几件" prop="fullCount">
          <el-input v-model="form.fullCount" placeholder="请输入满几件" />
        </el-form-item>
        <el-form-item label="打几折" prop="discount">
          <el-input v-model="form.discount" placeholder="请输入打几折" />
        </el-form-item>
        <el-form-item label="折后价" prop="price">
          <el-input v-model="form.price" placeholder="请输入折后价" />
        </el-form-item>
        <el-form-item label="是否叠加其他优惠[0-不可叠加，1-可叠加]" prop="addOther">
          <el-input v-model="form.addOther" placeholder="请输入是否叠加其他优惠[0-不可叠加，1-可叠加]" />
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
import { listSkuLadder, getSkuLadder, delSkuLadder, addSkuLadder, updateSkuLadder } from "@/api/coupon/skuLadder";

export default {
  name: "SkuLadder",
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
      // 商品阶梯价格表格数据
      skuLadderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        skuId: null,
        fullCount: null,
        discount: null,
        price: null,
        addOther: null
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
    /** 查询商品阶梯价格列表 */
    getList() {
      this.loading = true;
      listSkuLadder(this.queryParams).then(response => {
        this.skuLadderList = response.rows;
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
        skuId: null,
        fullCount: null,
        discount: null,
        price: null,
        addOther: null
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
      this.title = "添加商品阶梯价格";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getSkuLadder(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改商品阶梯价格";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateSkuLadder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSkuLadder(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除商品阶梯价格编号为"' + ids + '"的数据项？').then(function() {
        return delSkuLadder(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('coupon/skuLadder/export', {
        ...this.queryParams
      }, `skuLadder_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
