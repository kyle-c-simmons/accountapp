<template>
  <div class="jumbotron">
  <h2>Get account</h2><br>
  <form class="form-horizontal">
    <fieldset>

      <!-- Form Name -->

      <!-- Text input-->
      <div class="form-group">
        <label class="col-md-2 control-label" for="firstName">First Name:</label>
        <div class="col-md-8">
          <input id="firstName" name="firstName" type="text" placeholder="Enter first name" class="form-control input-md" required="">

        </div>
      </div>

      <!-- Text input-->
      <div class="form-group">
        <label class="col-md-2 control-label" for="surname">Surname:</label>
        <div class="col-md-8">
          <input id="surname" name="surname" type="text" placeholder="Enter surname" class="form-control input-md" required="">

        </div>
      </div>

      <!-- Text input-->
      <div class="form-group">
        <label class="col-md-2 control-label" for="accountNumber">Account Number</label>
        <div class="col-md-8">
          <input id="accountNumber" name="accountNumber" type="text" placeholder="Enter account number" class="form-control input-md" required="">

        </div>
      </div>

      <button type="submit" class="btn btn-default">Submit</button>
    </fieldset>
  </form>
  </div>

</template>

<script>
  export default {
    name: 'getaccount',
    data: {
      newAccount: {
        firstname: '',
        surname: '',
        accountnumber: ''
      }

    },
    created: function () {

    },
    methods: {
      updatedAccount () {
        var data = this.newAccount;
        this.$http.put('http://localhost:8090/account/', data).then

      }
    }
  }
</script>
