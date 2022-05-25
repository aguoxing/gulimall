<template>
  <div class="category-brand-relation">

    <el-button
      style="margin-right: 10px"
      type="text"
      icon="el-icon-share"
      @click="handleAdd"
    >关联</el-button>

    <!-- 关联分类对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="open"
      width="650px"
      append-to-body
    >
      <el-form :model="form" ref="form" :inline="true" :rules="rules">
        <el-form-item>
          <el-cascader
            style="width: 350px;"
            size="small"
            filterable
            clearable
            v-model="form.catalogId"
            :options="categoryOptions"
            :props="categoryProps"
            @change="handleCategoryChange"
          ></el-cascader>
        </el-form-item>
        <el-form-item>
          <el-button
            type="primary"
            plain
            icon="el-icon-plus"
            size="small"
            @click="submitForm"
          >新增</el-button>
        </el-form-item>
      </el-form>

      <el-table
        border
        v-loading="loading"
        :data="categoryBrandRelationList"
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="品牌名" align="center" prop="brandName" />
        <el-table-column label="分类名" align="center" prop="catalogName" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="text"
              icon="el-icon-delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['product:categoryBrandRelation:remove']"
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

    </el-dialog>

  </div>
</template>

<script>
import { listCategoryBrandRelation, delCategoryBrandRelation, addCategoryBrandRelation, updateCategoryBrandRelation } from "@/api/product/categoryBrandRelation";
import {listTreeCategory} from "@/api/product/category";

export default {
  name: "CategoryBrandRelation",
  props: {
    brandInfo: {
      type: Object
    }
  },
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
      // 品牌分类关联表格数据
      categoryBrandRelationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        brandId: null,
        catalogId: null,
        brandName: null,
        catalogName: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},

      categoryProps: {
        label: 'name',
        value: 'catId'
      },
      categoryOptions: []
    };
  },
  created() {
    this.getList();
    this.getCategoryList();
  },
  methods: {
    getCategoryList() {
      listTreeCategory().then(res => {
        this.categoryOptions = res.data;
      })
    },
    /** 查询品牌分类关联列表 */
    getList() {
      this.loading = true;
      this.queryParams.brandId = this.brandInfo.brandId;
      listCategoryBrandRelation(this.queryParams).then(response => {
        this.categoryBrandRelationList = response.rows;
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
        brandId: null,
        catalogId: null,
        brandName: null,
        catalogName: null
      };
      this.resetForm("form");
    },
    handleAdd() {
      this.reset();
      this.title = '添加品牌分类关联';
      this.open = true;
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCategoryBrandRelation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            this.form.catalogId = this.form.catalogId[this.form.catalogId.length -1];
            this.form.brandId = this.brandInfo.brandId;
            this.form.brandName = this.brandInfo.name;
            addCategoryBrandRelation(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              // this.open = false;
              this.getList();
              this.reset();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除关联的数据项？').then(function() {
        return delCategoryBrandRelation(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },

    handleCategoryChange() {

    }
  }
};
</script>
