// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Vuex from 'vuex'
import App from './App'
import store from './store'
import 'lib-flexible/flexible.js'
import router from './router'
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import  './api/fun.js'
Vue.prototype.HOST = '/api'
import './assets/icon/font_1745283_04i0c0mffuw6/iconfont.css'
import axios from 'axios'
import Router from 'vue-router'
Vue.use(Router)
const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}
Vue.use(Vuex)
Vue.prototype.$axios =axios

Vue.use(Element, { size: 'small' })

new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store
})
