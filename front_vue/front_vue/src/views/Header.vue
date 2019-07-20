<template>
  <div class="home-header">
    <div class="collapse-btn">
      <i class="el-icon-menu"></i>
    </div>
    <div class="header-logo">技术支撑管理系统</div>
    <div class="header-right">
      <div class="header-user-con">
        <!-- 全屏显示 -->
        <div class="btn-fullscreen">
          <el-tooltip effect="dark" :content="fullscreen?`取消全屏`:`全屏`" placement="bottom">
            <i class="el-icon-data-board"></i>
          </el-tooltip>
        </div>
        <!-- 消息中心 -->
        <div class="btn-message">
          <el-badge is-dot :hidden="readAll" class="item">
            <el-tooltip effect="dark" :content="message?`有${message}条未读消息`:`消息中心`" placement="bottom">
              <router-link to="/tabs">
                <i class="el-icon-bell"></i>
              </router-link>
            </el-tooltip>
          </el-badge>
        </div>
        <!-- 用户头像 -->
        <div class="user-avator">

        </div>
        <!-- 用户名下拉菜单 -->
        <el-dropdown>
          <span class="el-dropdown-link">
            {{username}}<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>黄金糕</el-dropdown-item>
            <el-dropdown-item>狮子头</el-dropdown-item>
            <el-dropdown-item divided>退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
  </div>
</template>

<script>
  import Logo from '@/components/logo'
  export default {
    name: "Header",
    components:{
      Logo,
    },
    created(){
      this.username=sessionStorage.getItem("userName");
    },
    data(){
      return{
        fullscreen:false,
        readAll:false,
        message: '',
        username:'',
      }
    }
  }
</script>

<style scoped>
  .home-header{
    position: relative;
    box-sizing: border-box;
    width: 100%;
    height: 70px;
    font-size: 22px;
    color: #fff;
  }
  .collapse-btn{
    float: left;
    padding: 0 21px;
    cursor: pointer;
    line-height: 70px;
  }
  .header-logo{
    float: left;
    width:250px;
    line-height: 70px;
  }
  .header-right{
    float: right;
    padding-right: 50px;
  }
  .header-user-con{
    display: flex;
    height: 70px;
    align-items: center;
  }
  .btn-message, .btn-fullscreen{
    position: relative;
    width: 30px;
    height: 30px;
    text-align: center;
    border-radius: 15px;
    cursor: pointer;
  }
  .btn-fullscreen{
    margin-right: 5px;
    font-size: 24px;
  }

  .btn-message .el-icon-bell{
    color: #fff;
  }
</style>
