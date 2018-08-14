<template>

  <div class="jumbotron">
    <div v-if="!hideDashboard">
      <h1 align="left">Dashboard</h1>


      <div v-if="!showDashboard" class="dashboard">
        <br>
 

        <!-- Search form -->
        <div id="search-bar" class="active-cyan-3 active-cyan-4 mb-4 md-form">
          <input v-if="searchFirstname" v-model="searchValue" @click="displayOneAccount = true,
        searchFirstname = true, getAccountById(searchValue)" class="form-control" type="text"
                 placeholder="Search By First Name" aria-label="Search">

          <input v-else-if="searchSurname" v-model="searchValue" @click="searchFirstname = false,
        displayOneAccount = true, searchSurname = true, getAccountById(searchValue)" class="form-control"
                 type="text" placeholder="Search By Surname" aria-label="Search">

          <input v-else-if="searchAccountnumber" v-model="searchValue" @click="searchFirstname = false,
        displayOneAccount = true, searchSurname = false, searchAccountnumber = true,  getAccountById(searchValue)" class="form-control"
                 type="text" placeholder="Search By Account number" aria-label="Search">
        </div>

        <div id="searchDropdown" class="dropdown">
          <button class="btn btn-primary dropdown-toggle" placeholder="Search by:" type="button" data-toggle="dropdown">Search by:
            <span class="caret"></span></button>
          <ul class="dropdown-menu">
            <li><a @click="displayOneAccount = true, searchFirstname = true" href="#">Search by First name</a></li>

            <li ><a @click="searchFirstname = false, displayOneAccount = false,
          searchSurname = true" href="#">Search by Surname</a></li>

            <li ><a @click="searchFirstname = false, displayOneAccount = true,
          searchSurname = false, searchAccountnumber = true" href="#">Search by Account number</a></li>
          </ul>
        </div>


        <br><br><br><br>

        <div>
          <table  class="table table-stripped">
            <thead>
            <tr>
              <th>FIRST_NAME</th>
              <th>SURNAME</th>
              <th>ACCOUNT_NUMBER</th>
              <th>EDIT</th>
              <th>DELETE</th>
            </tr>
            </thead>

            <tbody v-if="!displayOneAccount">
            <tr v-for="account in accounts" :key="account._id">

              <td  style="padding:10px; text-align:left;">{{ account.firstname }}</td>
              <td style="padding:10px; text-align:left;">{{ account.surname }} </td>
              <td style="padding:10px; text-align:left;">{{ account.accountnumber }}</td>
              <td style="padding:10px; text-align:left;"> <button type="button"
                                                                  @click="getFormData(account.firstname,
                                                                  account.surname, account.accountnumber),
                                                                  getAccountId(account.searchValue),
                                                                  hideDashboard = true"
                                                                  class="btn btn-default btn-sm btn-success">
                <span class="glyphicon glyphicon-plus"></span> Edit
              </button></td>
              <td style="padding:10px; text-align:left;"> <button type="button" @click="deleteAccount(account.searchValue)" class="btn btn-default btn-sm btn-danger">
                <span class="glyphicon glyphicon-minus" @click=""></span> Delete
              </button></td>
            </tr>
            </tbody>

            <tbody v-else-if="searchFirstname" >

            <tr  v-for="account in filterAccount" :key="account.searchValue">
              <td   style="padding:10px; text-align:left;">{{ account.firstname }}</td>
              <td style="padding:10px; text-align:left;">{{ account.surname }} </td>
              <td style="padding:10px; text-align:left;">{{ account.accountnumber }}</td>
              <td style="padding:10px; text-align:left;"> <button type="button"
                                                                  @click="getFormData(account.firstname,
                                                                  account.surname, account.accountnumber),
                                                                  getAccountId(account.searchValue),
                                                                  hideDashboard = true"
                                                                  class="btn btn-default btn-sm btn-success">
                <span class="glyphicon glyphicon-plus"></span> Edit
              </button></td>
              <td style="padding:10px; text-align:left;"> <button type="button" @click="deleteAccount(account.searchValue)" class="btn btn-default btn-sm btn-danger">
                <span class="glyphicon glyphicon-minus" @click=""></span> Delete
              </button></td>
            </tr>

            </tbody>

            <tbody v-else-if="searchSurname" >

            <tr  v-for="account in filterAccountSurname" :key="account.searchValue">
              <td   style="padding:10px; text-align:left;">{{ account.firstname }}</td>
              <td style="padding:10px; text-align:left;">{{ account.surname }} </td>
              <td style="padding:10px; text-align:left;">{{ account.accountnumber }}</td>
              <td style="padding:10px; text-align:left;"> <button type="button"
                                                                  @click="getFormData(account.firstname,
                                                                  account.surname, account.accountnumber),
                                                                  getAccountId(account.searchValue),
                                                                  hideDashboard = true"
                                                                  class="btn btn-default btn-sm btn-success">
                <span class="glyphicon glyphicon-plus"></span> Edit
              </button></td>
              <td style="padding:10px; text-align:left;"> <button type="button" @click="deleteAccount(account.searchValue)" class="btn btn-default btn-sm btn-danger">
                <span class="glyphicon glyphicon-minus" @click=""></span> Delete
              </button></td>
            </tr>

            </tbody>

            <tbody v-else-if="searchAccountnumber" >

            <tr  v-for="account in filterAccountAccountnumber" :key="account.searchValue">
              <td   style="padding:10px; text-align:left;">{{ account.firstname }}</td>
              <td style="padding:10px; text-align:left;">{{ account.surname }} </td>
              <td style="padding:10px; text-align:left;">{{ account.accountnumber }}</td>
              <td style="padding:10px; text-align:left;"> <button type="button"
                                                                  @click="getFormData(account.firstname,
                                                                  account.surname, account.accountnumber),
                                                                  getAccountId(account.searchValue),
                                                                  hideDashboard = true"
                                                                  class="btn btn-default btn-sm btn-success">
                <span class="glyphicon glyphicon-plus"></span> Edit
              </button></td>
              <td style="padding:10px; text-align:left;"> <button type="button" @click="deleteAccount(account.searchValue)" class="btn btn-default btn-sm btn-danger">
                <span class="glyphicon glyphicon-minus" @click=""></span> Delete
              </button></td>
            </tr>

            </tbody>


          </table>


          <tr>
            <td colspan="1"></td>
            <td><button class="btn" @click="showDashboard = true">Hide accounts</button></td>
          </tr>
          <p></p>
        </div>

      </div>
      <div v-else-if="showDashboard">
        <tr>
          <td colspan="1"></td>
          <td><button class="btn" @click="showDashboard = false">Show accounts</button></td>
        </tr>
      </div>

    </div>


    <div v-else-if="hideDashboard">
      <h2>Edit account</h2><br>
      <form @submit.prevent="isSubmitted = true" class="form-horizontal">
        <fieldset>

          <!-- Form Name -->

          <!-- Text input-->
          <div class="form-group">
            <label class="col-md-2 control-label" for="firstname">First Name:</label>
            <div class="col-md-8">
              <input id="firstname" name="firstname" :value="this.set_firstname" type="text" placeholder="Enter first name" class="form-control input-md">

            </div>
          </div>

          <!-- Text input-->
          <div class="form-group">
            <label class="col-md-2 control-label" for="surname">Surname:</label>
            <div class="col-md-8">
              <input id="surname" name="surname" :value="this.set_surname" type="text" placeholder="Enter surname" class="form-control input-md">
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group">
            <label class="col-md-2 control-label" for="accountnumber">Account Number</label>
            <div class="col-md-8">
              <input id="accountnumber" name="accountnumber" :value="set_accountnumber" type="text" placeholder="Enter account number" class="form-control input-md">

            </div>
          </div>

          <button type="submit" class="btn btn-default" @click="editAccount">Submit</button>
          <td><button class="btn" @click="hideDashboard = false">Back</button></td>
        </fieldset>
      </form>
    </div>
  </div>


</template>

<script>
  import Vue from 'vue'

  export default {
    name: 'dashboard',
    data() {
      return {
        set_id: '',
        set_firstname: '',
        set_surname: '',
        set_accountnumber: '',
        isSubmitted: false,
        accounts: [''],
        oneAccount: [{

        } ],
        showDashboard: false,
        hideDashboard: false,
        formData: {
          firstname: '',
          surname: '',
          accountnumber: ''
        },
        displayOneAccount: false,
        searchValue: '',
        searchFirstname: true,
        searchSurname: false,
        searchAccountnumber: false

      }
    },
    created: function () {
      this.getAccounts();
      this.getAccountById(searchValue);
    },
    computed: {
      filterAccount:function () {
        if(this.searchFirstname) {
          return this.accounts.filter((account) => {
            return account.firstname.toLowerCase().match(this.searchValue.toLowerCase());
          });
        }
      },
      filterAccountSurname:function () {
        if(this.searchSurname) {
          return this.accounts.filter((account) => {
            return account.surname.toLowerCase().match(this.searchValue.toLowerCase());
          });
        }
      },
      filterAccountAccountnumber:function () {
        if(this.searchAccountnumber) {
          return this.accounts.filter((account) => {
            return account.accountnumber.toLowerCase().match(this.searchValue.toLowerCase());
          });
        }
      }
    },

    methods: {
      getAccounts () {
        this.$http.get('http://localhost:8090/account/').then((res) => {
          this.accounts = res.body;
          console.log(this.accounts);
        }, (err) => {
          console.log(err);
        });
      },
      getAccountById (new_id) {
        new_id = this.searchValue;
        console.log("Id retrieved: " + new_id);

        this.$http.get('http://localhost:8090/account/' + new_id).then((res) => {
          this.oneAccount = res.body;
          console.log(this.oneAccount);
        }, (err) => {
          console.log(err);
        });
      },
      deleteAccount (_id) {
        console.log('You are deleting user id: ' + _id);
        this.$http.delete('http://localhost:8090/account/' + _id, {body: this.accounts});
        window.location.reload(false);

      },
      getAccountId (_id) {
        console.log("You are editing user id: " + _id);
        var id = this.set_id = _id;
        console.log("stored id: " + id);
      },
      getFormData (firstname, surname, accountnumber) {
        console.log("First name: " + firstname +
        "\nSurname: " + surname +
        "\nAccount number: " + accountnumber);

        var get_firstname = this.set_firstname = firstname;
        var get_surname = this.set_surname = surname;
        var get_accountnumber = this.set_accountnumber = accountnumber;
        console.log(get_firstname, get_surname, get_accountnumber);
      },
      filteredAccounts(_id) {
        var id = this.searchValue = _id;
        console.log(id);
      },
      editAccount() {
        console.log("First name: " + firstname.value + '\nSurname: ' + surname.value + '\nAccount number: ' +
          accountnumber.value);
        var name = this.formData.firstname = firstname.value;
        var nameTwo = this.formData.surname = surname.value;
        var account = this.formData.accountnumber = accountnumber.value;

        var new_id = this.set_id;
        console.log("Id retrieved: " + new_id);

        this.$http.put('http://localhost:8090/account/' + new_id, {firstname: name, surname: nameTwo, accountnumber: account}, function(response) {
        });
        window.location.reload(false);
        hideDashboard = false;
      },

    },

  }
</script>

<style type="text/css">
  .btn {
    color: #FDFFFC;
    background-color: #235789;
  }

  .active-cyan-2 input[type=text]:focus:not([readonly]) {
    border-bottom: 1px solid #4dd0e1;
    box-shadow: 0 1px 0 0 #4dd0e1;
  }
  .active-cyan input[type=text] {
    border-bottom: 1px solid #4dd0e1;
    box-shadow: 0 1px 0 0 #4dd0e1;
  }
  .active-cyan .fa, .active-cyan-2 .fa {
    color: #4dd0e1;
  }
  .form-inline  {
    width: 500px;
  }

  .md-form {
    width: 40%;
  }

  #search-bar {
    float: left;
  }

  #btn-search {
    margin-left: 40px;
    float: left;
  }

  .dropdown {
    float:left;
  }

  #searchDropdown {
    margin-left: 20px;
  }

  .active-cyan-4 input[type=text]:focus:not([readonly]) {
    border: 1px solid #4dd0e1;
    box-shadow: 0 0 0 1px #4dd0e1;
  }
  .active-cyan-3 input[type=text] {
    border: 1px solid #4dd0e1;
    box-shadow: 0 0 0 1px #4dd0e1;
  }



</style>
