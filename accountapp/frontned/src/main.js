// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.

// =============== Base libraries integration ==================
import Vue from 'vue'
import VueResource from 'vue-resource'
import VueTranslate from 'vue-translate-plugin'

Vue.use(VueResource)
Vue.use(VueTranslate)

import store from './store'
import router from './router'

// ===== Bootstrap components integration (JQuery needed) ======
window.$ = window.jQuery = require('jquery')
require('bootstrap-sass')

// ======================= Base Component ======================
import App from './App'
import NavBar from './components/Navbar'
import Dashboad from './components/Dashboard'

// ======================== Vue Instance =======================
/* eslint-disable no-new */
//Vue.use(VueRouter)

var vm1 = new Vue({
  router,
  store,
  el: '#vm1',
  render: h => h(App),
  data: {
    hideDashboardPage: false,
    showvm1: false

  }
});
