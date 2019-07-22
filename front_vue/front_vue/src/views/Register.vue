<template>
  <div class="register-container">
    <div class="ms-register">
      <Logo/>
      <div class="background">
        <h3 class="title">用户注册</h3>
        <el-upload
          class="avatar-uploader"
          ref="upload"
          name="smfile"
          action="/sm.ms/upload"
          :show-file-list="false"
          :on-change="imgPreview"
          :on-success="uploadSuccess"
          :on-error="uploadError"
          :before-upload="beforeUpload"
          :auto-upload="false">
          <img v-if="imageUrl" :src="imageUrl" class="avatar">
          <i v-else class="el-icon-user avatar-uploader-icon"></i>
          <div slot="tip" class="el-upload__tip"><span style="color: red">*</span>请点击上传jpg/png文件，且不超过2M</div>
        </el-upload>
        <el-form class="ms-content" :model="user" :rules="rules" ref="user" v-loading="loading">
          <el-form-item prop="userName">
            <el-input v-model="user.userName" placeholder="用户名">
              <el-button slot="prepend" icon="el-icon-user" ></el-button>
            </el-input>
          </el-form-item>
          <el-form-item prop="userNickName">
            <el-input v-model="user.userNickName" placeholder="昵称">
              <el-button slot="prepend" icon="el-icon-postcard" ></el-button>
            </el-input>
          </el-form-item>
          <el-form-item prop="password" required>
            <el-input type="password" v-model="user.password" placeholder="密码">
              <el-button slot="prepend" icon="el-icon-key" ></el-button>
            </el-input>
          </el-form-item>
          <el-form-item prop="rePassword">
            <el-input type="password" v-model="user.rePassword" placeholder="确认密码">
              <el-button slot="prepend" icon="el-icon-connection" ></el-button>
            </el-input>
          </el-form-item>
          <el-form-item prop="userMail">
            <el-input v-model="user.userMail" placeholder="邮箱">
              <el-button slot="prepend" icon="el-icon-message" ></el-button>
            </el-input>
          </el-form-item>
          <el-form-item prop="userPhone">
            <el-input v-model="user.userPhone" placeholder="电话">
              <el-button slot="prepend" icon="el-icon-phone" ></el-button>
            </el-input>
          </el-form-item>
          <div class="login-btn">
            <el-button type="primary" style="width:65%;" @click.native="registerUser">注册</el-button>
            <el-button style="width:25%;" @click="goBack">返回</el-button>
          </div>
        </el-form>
      </div>
    </div>
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
          userNickName: '',
          password: '',
          rePassword: '',
          userMail: '',
          userPhone: '',
          picName:'',
          userPicUrl:'',
          userPicDelUrl:'',
        },
        imageUrl: '',
        loading: false,
        rules:{
          userName: [
            { required: true, message: '请输入用户名称', trigger: 'blur' },
            { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' },
            { pattern: /^[a-zA-Z0-9_]+$/, message: '请输入合法的字符' }
          ],
          userNickName: [
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
            { pattern: /^1(3|4|5|6|7|8|9)\d{9}$/, message: '请输入合法的电话号'}
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
        if (regex.test(fileName.toLowerCase ())) {
          this.imageUrl = URL.createObjectURL(file.raw);
        } else {
          this.$message.error('请选择图片文件');
        }
      },
      registerUser(){
        this.$refs.user.validate((valid) => {
          //代表通过验证 ,将参数传回后台
          if (valid){
            this.$refs.upload.submit();
            }
        });
      },
      uploadSuccess(res, file) {
        if(res.code == 'success'){
          this.user.userPicUrl = res.data.url;
          this.user.userPicDelUrl = res.data.delete;
          this.user.picName = res.data.filename;
          this.loading=true;
          let params = Object.assign({}, this.user);
          this.$post("/user/registerUser",params)
            .then((result) => {
              if (result.success) {
                this.$message.success(result.message);
                this.$router.push({name:'Login'})
              }else{
                this.$message.error(result.message);
              }
              this.loading=false;
            })
            .catch((error) => {
              this.$message.error("后端异常，请联系管理员");
              this.loading=false;
            });
        }else {
          this.$message.error("图片上传异常，请更换图片或联系管理员");
          this.loading=false;
        }
      },
      uploadError(res, file) {
        this.$message.error("图片上传异常，请更换图片或联系管理员");
        this.loading=false;
      },
      beforeUpload(file){
        const isLt2M = file.size / 1024 / 1024 < 2;
        const fileName = file.name;
        let regex = /(.jpg|.jpeg|.gif|.png|.bmp)$/;
        const hasFIle=regex.test(fileName.toLowerCase ())
        if (!hasFIle) {
          this.$message.error('请选择图片文件');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        console.log(isLt2M && hasFIle);
        return  isLt2M && hasFIle;
      }
    }
  }
</script>

<style scoped>
  .register-container{
    width: 100%;
    height: 100%;
    position:relative;
    background-image: url(../assets/img/bg.png);
    background-size: 100%;
  }
  .ms-register{
    position: absolute;
    left:45%;
    top:25%;
    width:500px;
    text-align: center;
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
  .el-upload__tip{
    color: #fff;
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
    margin-top: 10px;
    width: 90px;
    height: 90px;
    display: block;
    border-radius: 50%;
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
