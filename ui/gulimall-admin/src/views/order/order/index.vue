<template>
  <div class="app-container">
    <el-form ref="form" :model="form" :rules="rules" label-width="80px">
      <el-form-item label="订单号" prop="out_trade_no">
        <el-input v-model="form.out_trade_no" placeholder="请输入订单号" />
      </el-form-item>
      <el-form-item label="总金额" prop="total_amount">
        <el-input v-model="form.total_amount" placeholder="请输入总金额" />
      </el-form-item>
      <el-form-item label="订单名称" prop="subject">
        <el-input v-model="form.subject" placeholder="请输入订单名称" />
      </el-form-item>
      <el-form-item label="产品编号" prop="product_code">
        <el-input v-model="form.product_code" placeholder="请输入产品编号" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm">确 定</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {demoPay} from "@/api/order/order";

export default {
  name: 'demo',
  data() {
    return {
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
    }
  },
  created() {
    this.reset();
  },
  methods: {
    // 表单重置
    reset() {
      this.form = {
        out_trade_no: null,
        total_amount: null,
        subject: null,
        product_code: 'FAST_INSTANT_TRADE_PAY'
      };
      this.resetForm("form");
    },
    submitForm() {
      demoPay(this.form).then(res => {
        let routerData = this.$router.resolve({path: '/pay', query: {payHtmlContent: res}});

        window.open(routerData.href, "_blank");
      });
    }
  }
}
</script>
