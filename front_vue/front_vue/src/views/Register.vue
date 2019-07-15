<template>
  <div class="register-container">
    <Logo/>
    <el-form class="register-page" label-width="80px" :model="user" :rules="rules" ref="user">
      <h3 class="title">用户注册</h3>
      <el-form-item label="用户头像">
        <el-upload
          class="avatar-uploader"
          action="https://jsonplaceholder.typicode.com/posts/"
          :show-file-list="false"
          :on-change="imgPreview"
          :auto-upload="false">
          <img v-if="user.picUrl" :src="user.picUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload>
      </el-form-item>
      <el-form-item label="用户名" prop="userName">
        <el-input v-model="user.userName"/>
      </el-form-item>
      <el-form-item label="昵称" prop="nickName">
        <el-input v-model="user.nickName"/>
      </el-form-item>
      <el-form-item label="密码" prop="password" required>
        <el-input type="password" v-model="user.password"/>
      </el-form-item>
      <el-form-item label="确认密码" prop="rePassword">
        <el-input type="password" v-model="user.rePassword"/>
      </el-form-item>
      <el-form-item label="邮箱" prop="userMail">
        <el-input v-model="user.userMail"/>
      </el-form-item>
      <el-form-item label="电话" prop="userPhone">
        <el-input v-model="user.userPhone"/>
      </el-form-item>
      <el-form-item style="width:100%;">
        <el-button type="primary" style="width:65%;">注册</el-button>
        <el-button style="width:25%;" @click="goBack">返回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import Logo from '@/components/logo'
  export default {
    name: "Register",
    components:{
      Logo,
    },
    data(){
      var validatePassword = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.rePassword !== '') {
            this.$refs.user.validateField('rePassword');
          }
          callback();
        }
      };
      var validateRePassword = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.user.password) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      return{
        user: {
          userName: '',
          nickName: '',
          password: '',
          rePassword: '',
          userMail: '',
          userPhone: '',
          picUrl:'',
        },
        rules:{
          userName: [
            { required: true, message: '请输入用户名称', trigger: 'blur' },
            { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' },
            { pattern: /^[a-zA-Z0-9_]+$/, message: '请输入合法的字符' }
          ],
          nickName: [
            { required: true, message: '请输入用户昵称', trigger: 'blur' },
            { min: 3, max: 30, message: '长度在 3 到 30 个字符', trigger: 'blur' },
            { pattern: /^[\u4e00-\u9fa5a-z0-9_]+$/, message: '请输入合法的字符' }
          ],
          password: [
            { validator: validatePassword, trigger: 'blur' }
          ],
          rePassword: [
            { validator: validateRePassword, trigger: 'blur' }
          ],
          userMail: [
            { required: true, message: '请输入用户邮箱', trigger: 'blur' },
            { pattern: /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/, message: '请输入合法的邮箱' }
          ],
          userPhone: [
            { required: true, message: '请输入用户电话', trigger: 'blur' },
            { pattern: /^1(3|4|5|6|7|8|9)\d{9}$/, message: '请输入合法的电话号' }
          ],
        },
      };
    },
    methods: {
      goBack: function () {
        this.$router.go(-1)
      },
      imgPreview (file, fileList) {
        let fileName = file.name;
        let regex = /(.jpg|.jpeg|.gif|.png|.bmp)$/;
        if (regex.test(fileName.toLowerCase())) {
          this.user.picUrl = URL.createObjectURL(file.raw);
        } else {
          this.$message.error('请选择图片文件');
        }
      },
    }
  }
</script>

<style scoped>
  .register-container{
    width: 100%;
    height: 100%;
    text-align: center;
  }
  .register-page {
    -webkit-border-radius: 5px;
    border-radius: 5px;
    margin: 30px auto;
    width: 500px;
    padding: 15px 35px 15px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 90px;
    height: 90px;
    line-height: 90px;
    text-align: center;
  }
  .avatar {
    width: 90px;
    height: 90px;
    display: block;
    border-radius: 50%;
  }
</style>
