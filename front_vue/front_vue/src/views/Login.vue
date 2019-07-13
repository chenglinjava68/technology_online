<template>
  <div class="login-container">
    <el-image :src="url">
      <div slot="error" class="image-slot">
        <i class="el-icon-picture-outline"></i>
      </div>
    </el-image>
    <el-form class="login-page">
      <h3 class="title">系统登录</h3>
      <el-form-item>
        <el-input v-model="user.username" placeholder="用户名"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="password" v-model="user.password" placeholder="密码"></el-input>
      </el-form-item>
      <el-checkbox class="remenber" v-model="checked">记住密码</el-checkbox>
      <el-form-item style="width:100%;">
        <el-button type="primary" style="width:65%;">登陆</el-button>
        <el-button style="width:25%;" @click="goRegister">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
    export default {
      name: "Login",
      data(){
        return{
          url:require("../assets/logo.png"),
          labelPosition: 'left',
          checked: false,
          user: {
            username: '',
            password: '',
          },
        }
      },
      methods: {
        goRegister: function () {
          this.$router.push({name:'Register'})
        }
      }
    }
</script>

<style scoped>
  .login-container{
    width: 100%;
    height: 100%;
    text-align: center;
  }
  .login-page {
    -webkit-border-radius: 5px;
    border-radius: 5px;
    margin: 30px auto;
    width: 350px;
    padding: 15px 35px 15px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  .remenber{
    margin: 0px 0px 15px;
    text-align: left;
  }
</style>
