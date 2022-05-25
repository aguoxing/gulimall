<template>
  <div class="app-container">
    <el-steps :active="activeSteps" finish-status="success">
      <el-step title="基本信息"></el-step>
      <el-step title="规格参数"></el-step>
      <el-step title="销售属性"></el-step>
      <el-step title="SKU信息"></el-step>
      <el-step title="保存完成"></el-step>
    </el-steps>
  </div>
</template>

<script>
export default {
  name: "SpuAdd",
  data() {
    return {
      activeSteps: 1
    }
  }
}
</script>

<style scoped>

</style>
