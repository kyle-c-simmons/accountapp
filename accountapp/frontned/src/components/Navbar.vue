<template>
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
        <router-view to="1" class="navbar-brand"></router-view>

      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#" @click="">Dashboard</a></li>
          <li><a href="#" @click="hideDashboard = true">Get account</a></li>
          <li><a href="#">Add account</a></li>
        </ul>
      </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
  </nav>
</template>

<script>
  export default {
    name: 'navbar',
    data: {
    }
  }
</script>


<style style="text/css">
  .container-fluid {

  }
</style>
