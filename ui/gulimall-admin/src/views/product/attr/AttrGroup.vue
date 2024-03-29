<template>
  <div class="attr-group">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="组名" prop="attrGroupName">
        <el-input
          v-model="queryParams.attrGroupName"
          placeholder="请输入组名"
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
          v-hasPermi="['product:group:add']"
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
          v-hasPermi="['product:group:edit']"
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
          v-hasPermi="['product:group:remove']"
        >删除</el-button>
      </el-col>
<!--      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['product:group:export']"
        >导出</el-button>
      </el-col>-->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="groupList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="组名" align="center" prop="attrGroupName" />
      <el-table-column label="排序" align="center" prop="sort" />
      <el-table-column label="组图标" align="center" prop="icon" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <div class="column-btn-container">
            <AttrGroupRelation
              :catalog-id="currentNode.catId"
              :attr-group-id="scope.row.attrGroupId"
            />
            <el-button
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="handleUpdate(scope.row)"
              v-hasPermi="['product:group:edit']"
            >修改</el-button>
            <el-button
              size="mini"
              type="text"
              icon="el-icon-delete"
              @click="handleDelete(scope.row)"
              v-hasPermi="['product:group:remove']"
            >删除</el-button>
          </div>
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

    <!-- 添加或修改属性分组对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="组名" prop="attrGroupName">
          <el-input v-model="form.attrGroupName" placeholder="请输入组名" />
        </el-form-item>
        <el-form-item label="排序" prop="sort">
          <el-input-number
            style="width: 100%;"
            :min="0"
            v-model="form.sort"
            placeholder="请输入排序"
          />
        </el-form-item>
        <el-form-item label="描述" prop="description">
          <el-input type="textarea" v-model="form.description" placeholder="请输入描述" />
        </el-form-item>
        <el-form-item label="组图标" prop="icon">
          <el-input v-model="form.icon" placeholder="请输入组图标" />
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
import { listGroup, getGroup, delGroup, addGroup, updateGroup } from "@/api/product/group";
import AttrGroupRelation from "@/views/product/attr/AttrGroupRelation";

export default {
  name: "Group",
  components: {
    AttrGroupRelation
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
      // 属性分组表格数据
      groupList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        attrGroupName: [
          {required: true, message: '组名不能为空', trigger: 'blur'}
        ],
        description: [
          {required: true, message: '描述不能为空', trigger: 'blur'}
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

  },
  methods: {
    /** 查询属性分组列表 */
    getList() {
      this.loading = true;
      listGroup(this.queryParams).then(response => {
        this.groupList = response.rows;
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
        attrGroupId: null,
        attrGroupName: null,
        sort: 0,
        description: null,
        icon: null,
        catalogId: null
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
      this.ids = selection.map(item => item.attrGroupId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加属性分组";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const attrGroupId = row.attrGroupId || this.ids
      getGroup(attrGroupId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改属性分组";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.catalogId = this.currentNode.catId;
          if (this.form.attrGroupId != null) {
            updateGroup(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addGroup(this.form).then(response => {
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
      const attrGroupIds = row.attrGroupId || this.ids;
      this.$modal.confirm('是否确认删除属性分组编号为"' + attrGroupIds + '"的数据项？').then(function() {
        return delGroup(attrGroupIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('product/group/export', {
        ...this.queryParams
      }, `group_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
