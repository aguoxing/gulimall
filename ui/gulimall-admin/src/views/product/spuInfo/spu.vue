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
        <spu-info :currentNode="currentNode"></spu-info>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import SpuInfo from "@/views/product/spuInfo/SpuInfo";
import CategoryTree from "@/views/product/category/CategoryTree";

export default {
  name: "SpuInfoIndex",
  components: {
    SpuInfo,
    CategoryTree
  },
  data() {
    return {
      currentNode: null
    };
  },
  created() {

  },
  methods: {
    handleQuery(data) {
      this.currentNode = data;
    }
  }
};
</script>
