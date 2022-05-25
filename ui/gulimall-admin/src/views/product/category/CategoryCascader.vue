<template>
  <div>
    <el-cascader
      style="width: 100%;"
      size="small"
      filterable
      clearable
      v-model="catelogIds"
      :options="categoryOptions"
      :props="categoryProps"
      @change="handleChange"
    ></el-cascader>
  </div>
</template>

<script>
import {listTreeCategory} from "@/api/product/category";

export default {
  name: "CategoryCascader",
  data() {
    return {
      categoryOptions: [],
      categoryProps: {
        label: 'name',
        value: 'catId'
      },
      catelogIds: null
    }
  },
  created() {
    this.getCategoryTree();
  },
  methods: {
    getCategoryTree() {
      listTreeCategory().then(res => {
        this.categoryOptions = res.data;
      })
    },
    handleChange(data) {
      let catalogId = data[data.length - 1];
      this.$emit("categoryChange", catalogId);
    }
  }
}
</script>

<style scoped>

</style>
