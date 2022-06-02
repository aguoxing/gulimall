<template>
  <div class="app-container">
    <div v-html="payHtmlContent" ref="pay"></div>
  </div>
</template>

<script>
export default {
  name: "pay",
  data() {
    return {
      payHtmlContent: null
    }
  },
  mounted() {
    this.payHtmlContent = this.$route.query.payHtmlContent;
    this.$nextTick(() => {
      this.$refs.pay.children[0].submit();
    })
  }
}
</script>

<style scoped>

</style>
