<template>
  <div>
    <el-cascader
      style="width: 100%;"
      size="small"
      filterable
      clearable
      v-model="catalogIds"
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
  props: {
    catalogId: {
      type: Number,
      default: null
    }
  },
  data() {
    return {
      categoryOptions: [],
      categoryProps: {
        label: 'name',
        value: 'catId'
      },
    }
  },
  created() {
    this.getCategoryTree();
  },
  computed: {
    catalogIds: {
      set() {
        return this.catalogIds;
      },
      get() {
        return this.catalogId;
      }
    }
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
