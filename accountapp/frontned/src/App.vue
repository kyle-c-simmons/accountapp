<template>
  <div id="vm1" class="container text-center">
    <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Account App</a>

        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#/home/" @click="clickDashboard = false, clickAddAccount = true">Dashboard</a></li>
            <li><a href="#/addaccount/" @click="clickDashboard = true, clickGetAccount = true, clickAddAccount = false">Add account</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div><!--/.container-fluid -->
    </nav>



    <div class="na" v-if="!clickDashboard">
      <component><Dashboard></Dashboard></component>
    </div>

    <div v-else-if="!clickAddAccount">
      <component><AddAccount></AddAccount></component>
    </div>

  </div>
</template>

<script>
import Navbar from './components/Navbar'
import Dashboard from './components/Dashboard'
import GetAccount from './components/GetAccount'
import AddAccount from './components/AddAccount'



export default {
  components: {Dashboard, GetAccount, AddAccount},
  data() {
    return {
      clickGetAccount: false,
      clickAddAccount: false,
      clickDashboard: false
    }
  }

}
</script>

<style lang="sass">

  // Bootstrap
  $icon-font-path: '../node_modules/bootstrap-sass/assets/fonts/bootstrap/';
  $link-color: #42b983;
  $brand-success: #42b983;
  @import 'node_modules/bootstrap-sass/assets/stylesheets/bootstrap';

  // font awesome
  $fa-font-path: '../node_modules/font-awesome/fonts/';
  @import 'node_modules/font-awesome/scss/font-awesome';

  //some styling adaptations
  h1
    color: #42b983
  p
    text-align: justify

  body
    background-color: #26A4DE
</style>
