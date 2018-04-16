<template>
  <div class="container-fluid">
    <div class="row no-svg-elements mbl">
      <div class="col-md-1"></div>
      <div class="col-md-6 welcome-line">
        <h2>Welcome to</h2>
        <h3>Traffic Information System</h3>
      </div>
      <div class="col-md-4">
        <form role="form" class="form-view">
          <div class="form-group">
            <h4>SIGN IN</h4>
          </div>
          <div class="form-group has-feedback">
            <input type="text" class="form-control flat" placeholder="User name" v-model="user_name">
            <span class="form-control-feedback fui-user"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="password" class="form-control flat" placeholder="Password" v-model="user_password">
            <span class="form-control-feedback fui-lock"></span>
          </div>
          <div class="form-group" title="Not recommended in the public network environment">
            <label class="checkbox">
              <input class="custom-checkbox" type="checkbox" data-toggle="checkbox"  v-model="auto_login">
              Remember me
            </label>
          </div>
          <div class="form-group">
            <button onclick="signIn" type="submit" class="btn btn-primary btn-wide btn-block">Sign in</button>
          </div>
          <a href="#">Register now</a>
          <span style="color: #1abc9c"> | </span>
          <a href="#">Forget passwords?</a>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: "SignIn",
    data () {
      return {
       user_name: '',
       user_password: '',
       auto_login: true
      }
    },
    methods: {
      signIn: function () {
        axios.post('/user', {
          userName: this.user_name,
          userPassword: this.user_password
        })
          .then(function (response) {
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
          });
      }
    }
  }

</script>

<style scoped>

  /* --- welcome style --- */
  @media screen and (max-width:992px){
    .welcome-line { display: none }
  }
  .welcome-line {
    margin-top: 350px;
  }
  h2,h3{
    text-align: left;
    font-style: italic;
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
