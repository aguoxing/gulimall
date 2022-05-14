<template>
  <div>
    <div class="head-container">
      <el-input
        v-model="categoryName"
        placeholder="请输入分类名称"
        clearable
        size="small"
        prefix-icon="el-icon-search"
        style="margin-bottom: 20px"
      />
    </div>
    <div class="head-container tree-scrollbar">
      <el-scrollbar style="height: 100%">
        <el-tree
          :data="categoryOptions"
          :props="defaultProps"
          node-key="catId"
          highlight-current
          accordion
          :expand-on-click-node="true"
          :filter-node-method="filterNode"
          :default-expanded-keys="defaultExpandedKeys"
          ref="categoryTree"
          @node-click="handleNodeClick"
        />
      </el-scrollbar>
    </div>
  </div>
</template>

<script>
import {listTreeCategory} from "@/api/product/category";

export default {
  name: "CategoryTree",
  data() {
    return {
      loading: false,
      queryParams: {
        pageNum: 1,
        pageSize: 10,
      },
      categoryName: undefined,
      categoryOptions: [],
      defaultProps: {
        children: "children",
        label: "name"
      },
      defaultExpandedKeys: []
    }
  },
  watch: {
    // 根据名称筛选分类树
    categoryName(val) {
      this.$refs.categoryTree.filter(val);
    }
  },
  created() {
    this.getTreeList();
  },
  methods: {
    getTreeList() {
      this.loading = true;
      listTreeCategory().then(response => {
        this.categoryOptions = response.data;
        this.loading = false;
      });
    },
    // 筛选节点
    filterNode(value, data) {
      if (!value) return true;
      return data.name.indexOf(value) !== -1;
    },
    // 节点单击事件
    handleNodeClick(data) {
      this.$emit("handleQuery", data);
    },
  }
}
</script>

<style scoped>
.tree-scrollbar {
  height: 580px;
  overflow: hidden;
}
.tree-scrollbar .el-scrollbar {
  width: 100%;
  height: 100%;
}
.tree-scrollbar .el-scrollbar /deep/ .el-scrollbar__wrap {
  height: 100%;
  overflow: scroll;
  overflow-x: hidden;
}

</style>
