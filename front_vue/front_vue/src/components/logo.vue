<template>
  <el-image :src="url">
    <div slot="error" class="image-slot">
      <i class="el-icon-picture-outline"></i>
    </div>
  </el-image>
</template>

<script>
    export default {
      name: "logo.vue",
      data(){
        return{
          url:require("../assets/logo.png"),
        }
      }
    }
</script>

<style scoped>

</style>
