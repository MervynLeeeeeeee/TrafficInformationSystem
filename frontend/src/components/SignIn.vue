<template>

  <el-container>
    <el-main>
      <el-row :gutter="10">
        <el-col  :md="2" >
          <div class="grid-content"></div>
        </el-col>
        <el-col  :md="12">
          <div class="welcome-line">
            <h1>Welcome to</h1>
            <h2>Traffic Information System</h2>
          </div>
        </el-col>
        <el-col  :md="8" >
          <div class="form-view">
            <el-form  ref="user" :model="user" :rules="contentRequired">
              <!--Title-->
              <p>SIGN IN</p>
              <!--Input username-->
              <el-form-item prop="user_name">
                <el-input
                  v-model="user.user_name"
                  type="text"
                  placeholder="User name"
                clearable>
                  <i slot="suffix" class="iconfont icon-account"/>
                </el-input>
              </el-form-item>
              <!--Input password-->
              <el-form-item prop="user_password">
                <el-input
                  v-model="user.user_password"
                  type="password"
                  placeholder="Password"
                  clearable>
                  <i slot="suffix" class="iconfont icon-password"/>
                </el-input>
              </el-form-item>
              <!--Remember me-->
              <el-form-item >
                <el-checkbox v-model="user.auto_login" class="item-left" label="Remember me"/>
              </el-form-item>
              <!--Submit button-->
              <el-form-item>
                <el-button @click="signIn('user')" type="primary" class="btn-block">Sign in</el-button>
              </el-form-item>
            </el-form>
            <!--Register-->
            <a href="#/Register">Register now</a>
            <span style="color: #409eff"> | </span>
            <!--Forget password-->
            <a href="#">Forget passwords?</a>
          </div>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
  import axios from 'axios'


  var instance  = axios.create({
    baseURL: 'localhost:8080',
    timeout: 1000,
    headers: {'Test-Header': 'myHeader'}
  })

  export default {
    name: "SignIn",
    data () {
      return {
<<
        user: {
          user_name: '',
          user_password: '',
          auto_login: true
        },
        contentRequired: {
          user_name: [
            { required: true, message: 'Username required', trigger: 'blur'}
          ],
          user_password: [
            { required: true, message: 'Password required', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      signIn: function (formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log('submit succeed!');
            instance.get('/user/login', {
              params: {
                user: this.user
              }
            })
              .then(function (response) {
                console.log(response);
              })
              .catch(function (error) {
                console.log(error);
              });
          } else {
            console.log('error submit!!');
            return false;
          }
        })
      }
    }
  }

</script>

<style scoped>

  /* --- welcome style --- */

  @media screen and (max-width:992px) {
    .welcome-line { d>>>>>>> master
125
isplay: none }
  }
  .welcome-line {
    margin-top: 350px;
  }

  h1,h2 {
    text-align: left;
    font-style: italic;
  }

  h1 {
    font-size: 53px;
  }

  h2 {
    font-size: 40px;
  }

  /* --- form-view --- */
  .form-view {
    background: white;
    margin-top: 300px;
    margin-left: auto;
    margin-right: auto;
    padding: 20px;
    max-width: 450px;
    box-shadow: 0 0 5px white;
    transition: 0.3s;
  }

  .form-view:hover {
    box-shadow: 0 0 1px #409eff;
  }

  .form-view p{
    color: #3f6bcb;
    font-size: 29px;
    text-align: left;
    font-weight: bold;
  }

  .form-view a {
    text-decoration: none;
    color: #409eff;
    font-weight: bold;
    font-size: 15px;
  }


  .form-view a:hover {
    color: #234985;
  }

  .btn-block{
    width: 100%;
  }



  /* --- Layout design --- */
  .grid-content {
    min-height: 1px;
  }

  .item-left{
    float: left;
  }

</style>
