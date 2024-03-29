<template>
  <div class="app-container">
    <el-row :gutter="10">
      <el-col :span="4" :xs="24">
        <category-tree
          ref="categoryTree"
          @handleQuery="handleQuery"
        ></category-tree>
      </el-col>
      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
          <el-form-item label="属性名" prop="attrName">
            <el-input
              v-model="queryParams.attrName"
              placeholder="请输入属性名"
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
              v-hasPermi="['product:attr:add']"
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
              v-hasPermi="['product:attr:edit']"
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
              v-hasPermi="['product:attr:remove']"
            >删除</el-button>
          </el-col>
          <!--      <el-col :span="1.5">
                  <el-button
                    type="warning"
                    plain
                    icon="el-icon-download"
                    size="mini"
                    @click="handleExport"
                    v-hasPermi="['product:attr:export']"
                  >导出</el-button>
                </el-col>-->
          <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="attrList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="55" align="center" />
          <el-table-column label="属性名" align="center" prop="attrName" />
          <el-table-column label="值类型" align="center" prop="valType">
            <template v-slot="scope">
              <dict-tag :options="dict.type.pms_value_type" :value="scope.row.valType"></dict-tag>
            </template>
          </el-table-column>
          <el-table-column label="属性图标" align="center" prop="icon" />
          <el-table-column label="可选值列表" align="center" prop="valueSelect" />
          <el-table-column label="属性类型" align="center" prop="attrType">
            <template v-slot="scope">
              <dict-tag :options="dict.type.pms_attr_type" :value="scope.row.attrType"></dict-tag>
            </template>
          </el-table-column>
          <el-table-column label="启用状态" align="center" prop="enable">
            <template v-slot="scope">
              <dict-tag :options="dict.type.pms_enable_status" :value="scope.row.enable"></dict-tag>
            </template>
          </el-table-column>
          <el-table-column label="所属分类" align="center" prop="catalogId" />
          <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
            <template slot-scope="scope">
              <el-button
                size="mini"
                type="text"
                icon="el-icon-edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['product:attr:edit']"
              >修改</el-button>
              <el-button
                size="mini"
                type="text"
                icon="el-icon-delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['product:attr:remove']"
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
      </el-col>
    </el-row>

    <!-- 添加或修改商品属性对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="open"
      width="650px"
      append-to-body
    >
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="属性名" prop="attrName">
          <el-input v-model="form.attrName" placeholder="请输入属性名" />
        </el-form-item>
        <el-form-item label="属性图标" prop="icon">
          <el-input v-model="form.icon" placeholder="请输入属性图标" />
        </el-form-item>
        <el-form-item label="值类型" prop="valType">
          <el-switch
            v-model="form.valType"
            active-text="允许多个值"
            inactive-text="只能单个值"
            active-color="#13ce66"
            inactive-color="#ff4949"
            :inactive-value="0"
            :active-value="1"
          ></el-switch>
        </el-form-item>
        <el-form-item label="可选值列表" prop="valueSelect">
          <el-select
            style="width: 100%;"
            v-model="form.valueSelect"
            multiple
            filterable
            allow-create
            default-first-option
          >
            <el-option
              v-for="(item,index) in valueSelectOptions"
              :key="index"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="启用状态" prop="enable">
          <el-switch
            v-model="form.enable"
            :inactive-value="0"
            :active-value="1"
          ></el-switch>
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
import { listAttr, getAttr, delAttr, addAttr, updateAttr } from "@/api/product/attr";
import CategoryTree from "@/views/product/category/CategoryTree";

export default {
  name: "Attr",
  dicts: ['pms_value_type', 'pms_enable_status', 'pms_attr_type'],
  components: {
    CategoryTree
  },
  props: {
    catId: String,
    catName: String
  },
  watch: {
    catId(val) {
      this.getList();
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
      // 商品属性表格数据
      attrList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        attrType: 0
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},

      valueSelectOptions: []
    };
  },
  created() {

  },
  methods: {
    /** 查询商品属性列表 */
    getList() {
      this.loading = true;
      listAttr(this.queryParams).then(response => {
        this.attrList = response.rows;
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
        attrId: null,
        attrName: null,
        searchType: 0,
        icon: null,
        valueSelect: null,
        attrType: 0,
        enable: 1,
        catalogId: null,
        showDesc: 0
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery(data) {
      this.queryParams.catalogId = data.catId;
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
      this.ids = selection.map(item => item.attrId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.form.catalogId = this.queryParams.catalogId;
      this.title = "添加销售属性";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const attrId = row.attrId || this.ids
      getAttr(attrId).then(response => {
        this.form = response.data;
        this.form.valueSelect = response.data.valueSelect.split(',');
        this.open = true;
        this.title = "修改销售属性";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.valueSelect = this.form.valueSelect.join(',');
          if (this.form.attrId != null) {
            updateAttr(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAttr(this.form).then(response => {
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
      const attrIds = row.attrId || this.ids;
      this.$modal.confirm('是否确认删除商品属性编号为"' + attrIds + '"的数据项？').then(function() {
        return delAttr(attrIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('product/attr/export', {
        ...this.queryParams
      }, `attr_${new Date().getTime()}.xlsx`)
    },

    categoryChange(data) {
      this.form.catalogId = data;
    }
  }
};
</script>
