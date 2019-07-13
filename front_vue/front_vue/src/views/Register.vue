<template>
  <div class="register-container">
    <el-image :src="url">
      <div slot="error" class="image-slot">
        <i class="el-icon-picture-outline"></i>
      </div>
    </el-image>
  </div>
</template>

<script>
    export default {
      name: "Register",
      data(){
        return{
          url:require("../assets/logo.png"),
        }
      }
    }
</script>

<style scoped>
  .register-container{
    width: 100%;
    height: 100%;
    text-align: center;
  }
</style>
