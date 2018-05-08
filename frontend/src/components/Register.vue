<template>
  <el-container>
    <el-main>
      <div class="form-view">
        <el-form  ref="register" :model="register" :rules="rule_register">
         <!--Title-->
          <p>SIGN UP</p>
          <!--Email-->
          <el-form-item prop="user_email">
            <el-input
              v-model="register.user_email"
              placeholder="*Email"
              clearable>
              <i slot="suffix" class="iconfont icon-email"/>
            </el-input>
          </el-form-item>
          <!--User name-->
          <el-form-item prop="user_name">
            <el-input
              v-model="register.user_name"
              placeholder="*User name"
              clearable>
              <i slot="suffix" class="iconfont icon-account"/>
            </el-input>
          </el-form-item>
          <!--Nick name-->
          <el-form-item prop="user_nickname">
            <el-input
              v-model="register.user_nickname"
              placeholder="*Nickname"
              clearable>
              <i slot="suffix" class="iconfont icon-atm"/>
            </el-input>
          </el-form-item>
          <!--Password-->
          <el-form-item prop="user_password">
            <el-input
              v-model="register.user_password"
              type="password"
              placeholder="*Password"
              clearable>
              <i slot="suffix" class="iconfont icon-password"/>
            </el-input>
          </el-form-item>
          <!--Confirm Password-->
          <el-form-item prop="password_confirm">
            <el-input
              v-model="register.password_confirm"
              type="password"
              placeholder="*Confirm password"
              clearable>
              <i slot="suffix" class="iconfont icon-password"/>
            </el-input>
          </el-form-item>
          <!--Gender-->
          <el-form-item>
            <el-radio-group class="item-left" v-model="register.user_gender">
              <el-radio label="male">Male</el-radio>
              <el-radio label="female">Female</el-radio>
            </el-radio-group>
          </el-form-item>
          <!--Protocol-->
          <el-form-item>
            <el-checkbox v-model="register.protocol_agreed" class="item-left">I agree with
              <a href="#">some protocol</a>
            </el-checkbox>
          </el-form-item>
          <!--Submit button-->
          <el-form-item>
            <el-button @click="submitRegister('register')" type="primary" class="btn-block">Sign up</el-button>
          </el-form-item>
        </el-form>
      </div>
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
    name: "Register",
    data () {
    var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('Please input password'));
        } else {
          if (this.register.password_confirm !== '') {
            this.$refs['register'].validateField('password-confirm');
          }
          callback();
        }
      }

      var validateCheckPass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('Please input password again'));
        } else if (value !== this.register.user_password) {
          callback(new Error('Password is not consistent'));
        } else {
          callback();
        }
      }

      return {
        register: {
          user_email: '',
          user_name: '',
          user_nickname: '',
          user_password: '',
          password_confirm: '',
          user_gender: 'male',
          protocol_agreed: true
        },
        rule_register: {
          user_email: [
            { required: true, message: 'Please input your email', trigger: 'blur' },
            { type: 'email', message: 'Input must be an email address', trigger: 'blur' }
          ],
          user_name: [
            { required: true, message: 'Please input username', trigger: 'blur' }
          ],
          user_nickname: [
            { required: true, message: 'Please input nickname', trigger: 'blur' }
          ],
          user_password: [
            { validator: validatePass, trigger: 'blur' }
          ],
          password_confirm: [
            { validator: validateCheckPass, trigger: 'blur' }
          ]
        }//rule_register
      }
    },
    methods: {
      submitRegister: function (formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log('submit succeed!')
            instance.get('/user/register', {
              params: {
                user: this.register
              }
            })
              .then(function (response) {
                console.log(response);
              })
              .catch(function (error) {
                console.log(error);
              });
          } else {
            console.log('error submit!!')
            return false
          }
        })
      }
    }
  }
</script>

<style scoped>
  /* --- form-view --- */
  .form-view {
    background: white;
    margin-top: 100px;
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

  .form-view p {
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
  .item-left{
    float: left;
  }

</style>
