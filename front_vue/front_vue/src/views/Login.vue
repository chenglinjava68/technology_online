<template>
  <div class="login-container">
    <div class="ms-login">
      <Logo/>
      <div class="background">
        <h3 class="title">系统登录</h3>
        <el-form class="ms-content" :model="user" :rules="rules" ref="user" v-loading="loading">
          <el-form-item prop="userName">
            <el-input v-model="user.userName" placeholder="用户名">
              <el-button slot="prepend" icon="el-icon-user" ></el-button>
            </el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input type="password" v-model="user.password" placeholder="密码">
              <el-button slot="prepend" icon="el-icon-key" ></el-button>
            </el-input>
          </el-form-item>
          <el-checkbox v-model="checked" class="remenber">记住密码</el-checkbox>
          <div class="login-btn">
            <el-button type="primary" style="width:65%;">登陆</el-button>
            <el-button style="width:25%;" @click="goRegister">注册</el-button>
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
  import Logo from '@/components/logo'
  export default {
    name: "Login",
    components:{
      Logo,
    },
    data(){
      return{
        url:require("../assets/logo.png"),
        labelPosition: 'left',
        checked: false,
        loading: false,
        user: {
          userName: '',
          password: '',
        },
        rules: {
          userName: [
            { required: true, message: '请输入用户名' }
          ],
          password: [
            { required: true, message: '请输入密码' }
          ]
        }
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
    position:relative;
    background-image: url(../assets/img/bg.png);
    background-size: 100%;
  }
  .ms-login{
    position: absolute;
    left:50%;
    top:50%;
    width:350px;
    margin:-190px 0 0 -175px;
    overflow: hidden;
  }
  .background{
    background: rgba(255,255,255, 0.3);
    border-radius: 5px;
  }
  .title{
    width: 100%;
    text-align: center;
    line-height: 50px;
    color: #fff;
    font-size: 20px;
    border-bottom: 1px solid #ddd;
  }
  .ms-content{
    padding: 30px 30px;
    text-align: center;
  }
  .remenber{
    margin: 0px 0px 15px;
    color: #fff;
  }
  .login-btn{
    text-align: center;
  }
  .login-btn button{
    width:100%;
    height:36px;
    margin-bottom: 10px;
  }

</style>
