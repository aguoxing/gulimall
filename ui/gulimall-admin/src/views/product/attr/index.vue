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
        <attr-group
          :currentNode="currentNode"
        ></attr-group>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import CategoryTree from "@/views/product/category/CategoryTree";
import AttrGroup from "@/views/product/attr/AttrGroup";

export default {
  name: "Attr",
  components: {
    CategoryTree,
    AttrGroup
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
