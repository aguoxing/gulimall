<template>
  <div class="spu-info">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品名称" prop="spuName">
        <el-input
          v-model="queryParams.spuName"
          placeholder="请输入商品名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属分类" prop="catalogId">
        <category-cascader
          :catalog-id="queryParams.catalogId"
          @categoryChange="queryParamsCategoryChange"
        ></category-cascader>
      </el-form-item>
      <el-form-item label="所属品牌" prop="brandId">
        <brand-select
          :model-brand-id="queryParams.brandId"
          @brandChange="queryParamsBrandChange"
        ></brand-select>
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
          v-hasPermi="['product:spuInfo:add']"
          :disabled="currentNode !== null && currentNode.catLevel !== 3"
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
          v-hasPermi="['product:spuInfo:edit']"
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
          v-hasPermi="['product:spuInfo:remove']"
        >删除</el-button>
      </el-col>
<!--      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['product:spuInfo:export']"
        >导出</el-button>
      </el-col>-->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="spuInfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="商品名称" align="center" prop="spuName" />
      <el-table-column label="商品描述" align="center" prop="spuDescription" />
      <el-table-column label="商品重量" align="center" prop="weight" />
      <el-table-column label="上架状态" align="center" prop="publishStatus">
        <template v-slot="scope">
          <dict-tag :options="dict.type.pms_publish_status" :value="scope.row.publishStatus"></dict-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['product:spuInfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['product:spuInfo:remove']"
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

    <!-- 添加或修改spu信息对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="open"
      width="650px"
      append-to-body
    >
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品名称" prop="spuName">
          <el-input v-model="form.spuName" placeholder="请输入商品名称" />
        </el-form-item>
        <el-form-item label="商品描述" prop="spuDescription">
          <el-input v-model="form.spuDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="所属分类" prop="catalogId">
          <category-cascader
            :catalog-id="form.catalogId"
            @categoryChange="categoryChange"
          ></category-cascader>
        </el-form-item>
        <el-form-item label="所属品牌" prop="brandId">
          <brand-select
            :model-brand-id="form.brandId"
            @brandChange="brandChange"
          ></brand-select>
        </el-form-item>
        <el-form-item label="重量" prop="weight">
          <el-input-number
            v-model="form.weight"
            style="width: 100%"
            :min="0"
            :precision="2"
          ></el-input-number>
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
import { listSpuInfo, getSpuInfo, delSpuInfo, addSpuInfo, updateSpuInfo } from "@/api/product/spuInfo";
import BrandSelect from "@/views/product/brand/BrandSelect";
import CategoryCascader from "@/views/product/category/CategoryCascader";

export default {
  name: "SpuInfo",
  dicts: ['pms_publish_status'],
  components: {
    BrandSelect,
    CategoryCascader
  },
  props: {
    currentNode: {
      type: Object,
      default: null
    }
  },
  data() {
    return {
      // 遮罩层
      loading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: false,
      // 总条数
      total: 0,
      // spu信息表格数据
      spuInfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        spuName: null,
        spuDescription: null,
        catalogId: null,
        brandId: null,
        weight: null,
        publishStatus: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        spuName: [
          {required: true, message: '名称不能为空', trigger: 'blur'}
        ],
        spuDescription: [
          {required: true, message: '描述不能为空', trigger: 'blur'}
        ],
        catalogId: [
          {required: true, message: '请选择分类', trigger: 'blur'}
        ]
      }
    };
  },
  watch: {
    'currentNode.catId': function (val) {
      this.queryParams.catalogId = val;
      this.getList();
    }
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询spu信息列表 */
    getList() {
      this.loading = true;
      listSpuInfo(this.queryParams).then(response => {
        this.spuInfoList = response.rows;
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
        spuName: null,
        spuDescription: null,
        catalogId: null,
        brandId: null,
        weight: 0,
        publishStatus: 2,
        createTime: null,
        updateTime: null
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
      this.title = "添加spu信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getSpuInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改spu信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateSpuInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSpuInfo(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除spu信息编号为"' + ids + '"的数据项？').then(function() {
        return delSpuInfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('product/spuInfo/export', {
        ...this.queryParams
      }, `spuInfo_${new Date().getTime()}.xlsx`)
    },

    categoryChange(data) {
      this.form.catalogId = data;
    },
    brandChange(data) {
      this.form.brandId = data;
    },
    queryParamsCategoryChange(data) {
      this.queryParams.catalogId = data;
    },
    queryParamsBrandChange(data) {
      this.queryParams.brandId = data;
    }
  }
};
</script>
