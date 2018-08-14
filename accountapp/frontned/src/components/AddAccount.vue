<template>
  <div class="jumbotron">
    <h2>Add account</h2><br>
    <form @submit.prevent="isSubmitted = true" class="form-horizontal">
      <fieldset>

        <!-- Form Name -->

        <!-- Text input-->
        <div class="form-group">
          <label class="col-md-2 control-label" for="firstname">First Name:</label>
          <div class="col-md-8">
            <input id="firstname" name="firstname" v-model="formData.firstname" type="text" placeholder="Enter first name" class="form-control input-md" required="">

          </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
          <label class="col-md-2 control-label" for="surname">Surname:</label>
          <div class="col-md-8">
            <input id="surname" name="surname" v-model="formData.surname" type="text" placeholder="Enter surname" class="form-control input-md" required="">
          </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
          <label class="col-md-2 control-label" for="accountnumber">Account Number</label>
          <div class="col-md-8">
            <input id="accountnumber" name="accountnumber" v-model="formData.accountnumber" type="text" placeholder="Enter account number" class="form-control input-md" required="">

          </div>
        </div>

        <button type="submit" class="btn btn-default" @click="addAccount">Submit</button>

      </fieldset>

    </form>
  </div>

</template>

<script>
  export default {
    name: 'addaccount',
    data() {
      return {
        isSubmitted: false,
        formData: {
          firstname: '',
          surname: '',
          accountnumber: ''
        }
      }

    },
    methods: {
      addAccount() {
        console.log("First name: " + firstname.value + '\nSurname: ' + surname.value + '\nAccount number: ' +
          accountnumber.value);

        var name = this.formData.firstname = firstname.value;
        var nameTwo = this.formData.surname = surname.value;
        var account = this.formData.accountnumber = accountnumber.value;

        console.log(name, nameTwo, account)

        this.$http.post('http://localhost:8090/account/', {firstname: name, surname: nameTwo, accountnumber: account}, function(response) {
        });
        window.location.reload(false);
      }
    }

  }
</script>
