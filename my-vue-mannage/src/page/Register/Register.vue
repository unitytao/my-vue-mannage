<template>
  <div class="login-wrap">
    <div class="ms-login">
      <div class="ms-title">用户注册</div>
      <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
        <el-form-item prop="account">
          <el-input v-model="param.account" placeholder="username">
            <el-button slot="prepend" icon="iconfont icon-yonghuming"></el-button>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            type="password"
            placeholder="password"
            v-model="param.password"
            @keyup.enter.native="submitForm()"
          >
            <el-button slot="prepend" icon="iconfont icon-lock"></el-button>
          </el-input>
        </el-form-item>
        <div class="login-btn">
          <el-button type="primary" @click="submitForm()">注册</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
  import {reqPwdRegister} from '../../api/index.js'
  export default {
    data: function() {
      return {
        param: {
          account: '',
          password: '',
        },
        rules: {
          account: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
          password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
        },

      };
    },
    methods: {
      async submitForm() {
        let result;
        const  param= this;
        if (!this.param.account) {
          // 用户名必须指定
          this.$message('用户名不能为空');
          return
        } else if (!this.param.password) {
          // 密码必须指定
          this.$message('密码不能为空');

        } else if (!(/(?=.*([a-zA-Z].*))(?=.*[0-9].*)[a-zA-Z0-9-*/+.~!@#$%^&*()]{6,20}$/.test(this.param.password))) {
          // 密码必须指定
          this.$message('密码格式错误');

        } else {
          const account =this.param.account
          const password =this.param.password
          result = await reqPwdRegister({account:account,password:password})
          console.log(result)
          if(result==='success'){
            this.$message('注册成功');
            this.$router.push('/root')
          }else {
            const msg = result.message;
            this.$message(msg)
          }
        }
      },
    },
  };
</script>

<style scoped>
  .login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    background-image: url(../../assets/img/login-bg.jpg);
    background-size: 100%;
  }
  .ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: #333333;
    border-bottom: 1px solid #ddd;
  }
  .ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: -190px 0 0 -175px;
    border-radius: 5px;
    background: rgba(255, 255, 255, 0.3);
    overflow: hidden;
  }
  .ms-content {
    padding: 30px 30px;
  }
  .login-btn {
    text-align: center;
  }
  .login-btn button {
    width: 100%;
    height: 36px;
    margin-bottom: 10px;
  }
</style>
