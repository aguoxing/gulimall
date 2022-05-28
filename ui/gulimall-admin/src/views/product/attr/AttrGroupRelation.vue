<template>
  <div class="attr-group-relation">

    <el-button
      style="margin-right: 10px"
      type="text"
      icon="el-icon-share"
      @click="handleAdd"
    >关联</el-button>

    <!-- 添加或修改属性&属性分组关联对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="open"
      width="850px"
      append-to-body
    >
      <el-row :gutter="10">
        <el-col :span="12" :xs="24">
          <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
              <el-button
                type="danger"
                plain
                icon="el-icon-delete"
                size="mini"
                @click="handleDelete"
              >移除</el-button>
            </el-col>
          </el-row>
          <el-table v-loading="loading" :data="attrGroupRelationList" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55" align="center" />
            <el-table-column label="属性名" align="center" prop="attrName" />
            <el-table-column label="可选值列表" align="center" prop="valueSelect" />
          </el-table>
          <pagination
            v-show="total>0"
            :total="total"
            :page.sync="queryParams.pageNum"
            :limit.sync="queryParams.pageSize"
            @pagination="getList"
          />
        </el-col>
        <el-col :span="12" :xs="24">
          <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
              <el-button
                type="primary"
                plain
                icon="el-icon-plus"
                size="mini"
                @click="handleSubmit"
              >新增</el-button>
            </el-col>
          </el-row>
          <el-table
            v-loading="loading"
            :data="attrList"
            @selection-change="handleAttrSelectionChange"
          >
            <el-table-column type="selection" width="55" align="center" />
            <el-table-column label="属性名" align="center" prop="attrName" />
            <el-table-column label="可选值列表" align="center" prop="valueSelect" />
          </el-table>
          <pagination
            v-show="attrTotal>0"
            :total="attrTotal"
            :page.sync="attrQueryParams.pageNum"
            :limit.sync="attrQueryParams.pageSize"
            @pagination="getAttrList"
          />
        </el-col>
      </el-row>
    </el-dialog>
  </div>
</template>

<script>
import { addAttrGroupRelation, delRelationByAttrIds } from "@/api/product/attrGroupRelation";
import { listAttrRelation, listNoAttrRelation } from "@/api/product/attr";

export default {
  name: "AttrGroupRelation",
  props: {
    attrGroupId: Number,
    catalogId: Number
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      attrIds: [],
      // 非单个禁用
      single: true,
      attrSingle: true,
      // 非多个禁用
      multiple: true,
      attrMultiple: true,
      // 总条数
      total: 0,
      attrTotal: 0,
      // 属性&属性分组关联表格数据
      attrGroupRelationList: [],
      attrList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10
      },
      attrQueryParams: {
        pageNum: 1,
        pageSize: 10
      }
    };
  },
  created() {

  },
  methods: {
    /** 查询属性&属性分组关联列表 */
    getList() {
      this.loading = true;
      this.queryParams.attrGroupId = this.attrGroupId;
      listAttrRelation(this.queryParams).then(response => {
        this.attrGroupRelationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    getAttrList() {
      this.attrQueryParams.catalogId = this.catalogId;
      this.attrQueryParams.attrGroupId = this.attrGroupId;
      listNoAttrRelation(this.attrQueryParams).then(res => {
        this.attrList = res.rows;
        this.attrTotal = res.total;
      })
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
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    handleAttrSelectionChange(selection) {
      this.attrIds = selection.map(item => item.attrId)
      this.attrSingle = selection.length!==1
      this.attrMultiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.getList();
      this.getAttrList();
      this.open = true;
      this.title = "新建关联";
    },
    /** 提交按钮 */
    handleSubmit() {
      addAttrGroupRelation({attrGroupId: this.attrGroupId, attrIds: this.attrIds}).then(res => {
        this.getAttrList();
        this.getList();
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除所选的数据项？').then(() => {
        return delRelationByAttrIds({attrGroupId: this.attrGroupId, attrIds: ids});
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
        this.getAttrList();
      }).catch(() => {});
    }
  }
};
</script>
