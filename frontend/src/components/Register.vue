<template>
  <div class="container">
    <div class="row no-svg-elements mbl">
        <form role="form" class="form-view">
          <div class="form-group">
            <h4>SIGN UP</h4>
          </div>
          <div class="form-group has-feedback">
            <input type="email" class="form-control flat" placeholder="* Email" v-model="user_email" required>
            <span class="form-control-feedback fui-mail"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="email" class="form-control flat" placeholder="* User name" v-model="user_name" required>
            <span class="form-control-feedback fui-user"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="email" class="form-control flat" placeholder="* Nick name" v-model="user_nickname" required>
            <span class="form-control-feedback fui-android"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="password" class="form-control flat" placeholder="* Password" v-model="user_password" required>
            <span class="form-control-feedback fui-lock"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="password" class="form-control flat" placeholder="* Confirm password" v-model="passwords_confirm" required>
            <span class="form-control-feedback fui-lock"></span>
          </div>
          <div class="form-group">
            <div class="row">
              <div class="col-sm-6">
                <label class="radio">
                  <input type="radio" data-toggle="radio" v-model="user_gender" value="male" data-radiocheck-toggle="radio" required>
                  male
                </label>
              </div>
              <div class="col-sm-6">
                <label class="radio">
                  <input type="radio" data-toggle="radio" v-model="user_gender" value="female" data-radiocheck-toggle="radio">
                  female
                </label>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label class="checkbox">
              <input class="custom-checkbox" type="checkbox" data-toggle="checkbox" v-model="protocol_agreed" checked="" required>
              I agree with
              <a href="#">balabala</a>
            </label>
          </div>
          <div class="form-group">
            <button class="btn btn-primary btn-wide btn-block">Sign up</button>
          </div>
        </form>
      </div>
  </div>
</template>

<script>
  export default {
    name: "Register",
    data () {
      return {
        user_email: '',
        user_name: '',
        user_nickname: '',
        user_password: '',
        passwords_confirm: '',
        user_gender: '',
        protocol_agreed: true
      }
    }
  }
</script>

<style scoped>
  /* --- form-view --- */
  .form-view {
    background: white;
    margin: 100px auto;
    padding: 20px;
    max-width: 450px;
    box-shadow: 0 0 5px white;
    transition: 0.3s;
  }
  .form-view:hover {
    box-shadow: 0 0 1px #1abc9c;
  }
  .form-view h4,label{
    text-align: left;
    font-weight: bold;
  }
  .form-view a {
    font-weight: bold;
    font-size: 15px;
  }

  /* --- form input style --- */
  .form-control {
    border-radius: 0;
    border: none;
    border-bottom: 3px solid white;
    transition: 0.1s;
  }
  .form-control:hover {
    border-bottom: 3px solid darkgrey;
    mask-border-outset: 5px;
  }
  .form-control:focus {
    border-bottom: 3px solid #1abc9c;
  }
</style>
