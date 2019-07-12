<template>
  <div class="Nofound-container">
    <el-image :src="url">
      <div slot="error" class="image-slot">
        <i class="el-icon-picture-outline"></i>
      </div>
    </el-image>
    <h1>当前页面找不到了</h1>
    <router-link :to="{ path: '/login' }"><span>回到主页</span></router-link>
  </div>
</template>

<script>
    export default {
      name: "NoFound",
      data(){
        return{
          url:require("../assets/logo.png")
        }
      }
    }
</script>

<style scoped>
  .Nofound-container{
    width: 100%;
    height: 100%;
    text-align: center;
  }
</style>
