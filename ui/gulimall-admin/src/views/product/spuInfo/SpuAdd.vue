<template>
  <div class="app-container">
    <el-row>
      <el-col :span="24">
        <el-steps :active="activeSteps" finish-status="success">
          <el-step title="基本信息"></el-step>
          <el-step title="规格参数"></el-step>
          <el-step title="销售属性"></el-step>
          <el-step title="SKU信息"></el-step>
          <el-step title="保存完成"></el-step>
        </el-steps>
      </el-col>
      <el-col :span="24" v-if="activeSteps === 0">
        <el-card>
          <el-form ref="form" :model="spuBaseInfoForm" :rules="spuBaseInfoFormRules" label-width="80px">
            <el-form-item label="商品名称" prop="spuName">
              <el-input v-model="spuBaseInfoForm.spuName" placeholder="请输入商品名称" />
            </el-form-item>
            <el-form-item label="商品描述" prop="spuDescription">
              <el-input v-model="spuBaseInfoForm.spuDescription" placeholder="请输入商品描述" />
            </el-form-item>
            <el-form-item label="分类" prop="catalogId">
              <category-cascader @categoryChange="categoryChange"></category-cascader>
            </el-form-item>
            <el-form-item label="品牌" prop="brandId">
              <brand-select @brandChange="brandChange"></brand-select>
            </el-form-item>
            <el-form-item label="商品重量" prop="weight">
              <el-input-number
                v-model="spuBaseInfoForm.weight"
                :min="0"
                :precision="3"
                :step="0.1"
                style="width: 100%"
              ></el-input-number>
            </el-form-item>
            <el-form-item label="商品介绍" prop="description"></el-form-item>
            <el-form-item>
              <el-button type="success" @click="handleSaveSpuBaseInfo">下一步</el-button>
            </el-form-item>
          </el-form>
        </el-card>
      </el-col>
      <el-col :span="24" v-if="activeSteps === 1"></el-col>
      <el-col :span="24" v-if="activeSteps === 2"></el-col>
      <el-col :span="24" v-if="activeSteps === 3"></el-col>
      <el-col :span="24" v-if="activeSteps === 4"></el-col>
    </el-row>
  </div>
</template>

<script>
import CategoryCascader from "@/views/product/category/CategoryCascader";
import BrandSelect from "@/views/product/brand/BrandSelect";

export default {
  name: "SpuAdd",
  components: {
    CategoryCascader,
    BrandSelect
  },
  data() {
    return {
      activeSteps: 0,
      spuBaseInfoForm: {},
      spuBaseInfoFormRules: {}
    }
  },
  methods: {
    handleSaveSpuBaseInfo() {
      this.activeSteps = 1;
    },
    categoryChange(data) {
      this.spuBaseInfoForm.catalogId = data;
    },
    brandChange(data) {
      this.spuBaseInfoForm.brandId = data;
    }
  }
}
</script>

<style scoped>

</style>
