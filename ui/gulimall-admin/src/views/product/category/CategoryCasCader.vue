<template>
  <div>
    <el-cascader
      style="width: 350px;"
      size="small"
      filterable
      clearable
      v-model="catelogIds"
      :options="categoryOptions"
      :props="categoryProps"
    ></el-cascader>
  </div>
</template>

<script>
export default {
  name: "CategoryCasCader",
  props: {
    value: {
      type: String
    }
  },
  data() {
    return {
      categoryOptions: [],
      categoryProps: {
        label: 'name',
        value: 'catId'
      },
      catelogIds: null
    }
  }
}
</script>

<style scoped>

</style>
