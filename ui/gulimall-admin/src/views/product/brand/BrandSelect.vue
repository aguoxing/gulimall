<template>
  <div>
    <el-select
      v-model="brandId"
      filterable
      clearable
      style="width: 100%;"
      @change="handleChange"
    >
      <el-option
        v-for="(item,index) in brandOptions"
        :key="index"
        :label="item.name"
        :value="item.brandId"
      ></el-option>
    </el-select>
  </div>
</template>

<script>
import {listBrand} from "@/api/product/brand";

export default {
  name: "BrandSelect",
  props: {
    modelBrandId: {
      type: Number,
      default: null
    }
  },
  data() {
    return {
      brandOptions: []
    }
  },
  created() {
    this.getBrandList();
  },
  computed: {
    brandId: {
      set() {
        return this.brandId;
      },
      get() {
        return this.modelBrandId;
      }
    }
  },
  methods: {
    getBrandList() {
      listBrand().then(res => {
        this.brandOptions = res.rows;
      })
    },
    handleChange(data) {
      this.$emit("brandChange", data);
    }
  }
}
</script>

<style scoped>

</style>
