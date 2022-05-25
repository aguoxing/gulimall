<template>
  <div class="attr-group-relation">

    <el-button
      style="margin-right: 10px"
      type="text"
      icon="el-icon-share"
      @click="handleAdd"
    >关联</el-button>

    <!-- 添加或修改属性&属性分组关联对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="属性id" prop="attrId">
          <el-input v-model="form.attrId" placeholder="请输入属性id" />
        </el-form-item>
        <el-form-item label="属性分组id" prop="attrGroupId">
          <el-input v-model="form.attrGroupId" placeholder="请输入属性分组id" />
        </el-form-item>
        <el-form-item label="属性组内排序" prop="attrSort">
          <el-input v-model="form.attrSort" placeholder="请输入属性组内排序" />
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
import { listAttrAttrgroupRelation, getAttrAttrgroupRelation, delAttrAttrgroupRelation, addAttrAttrgroupRelation, updateAttrAttrgroupRelation } from "@/api/product/attrAttrgroupRelation";

export default {
  name: "AttrGroupRelation",
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
      // 属性&属性分组关联表格数据
      attrAttrgroupRelationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        attrId: null,
        attrGroupId: null,
        attrSort: null
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
    /** 查询属性&属性分组关联列表 */
    getList() {
      this.loading = true;
      listAttrAttrgroupRelation(this.queryParams).then(response => {
        this.attrAttrgroupRelationList = response.rows;
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
        attrId: null,
        attrGroupId: null,
        attrSort: null
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
      this.title = "添加属性&属性分组关联";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getAttrAttrgroupRelation(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改属性&属性分组关联";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAttrAttrgroupRelation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAttrAttrgroupRelation(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除属性&属性分组关联编号为"' + ids + '"的数据项？').then(function() {
        return delAttrAttrgroupRelation(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('product/attrAttrgroupRelation/export', {
        ...this.queryParams
      }, `attrAttrgroupRelation_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
