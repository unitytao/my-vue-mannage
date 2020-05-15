import Vue from 'vue'
import VueRouter from 'vue-router'

import login from '../page/login/login.vue'
import Register from '../page/Register/Register.vue'
import root from '../page/root/root'
import addDepartment from '../components/addDepartment/addDepartment'
import addStation from '../components/addStation/addStation'
import addPersonnel from '../components/addPersonnel/addPersonnel'
import delDepartment from '../components/delDepartment/delDepartment'
import delStation from '../components/delStation/delStation'
import delPersonnel from '../components/delPersonnel/delPersonnel'
import work from '../components/work/work'



Vue.use(VueRouter)

export default new VueRouter({
  routes: [
    {
    path:'/root',
    component: root,
    children:[
    {
     path  : '/root/add_department',
     component: addDepartment
    },
    {
      path  : '/root/add_station',
      component: addStation
    },
    {
    path  : '/root/add_personnel',
    component: addPersonnel
    },
    {
    path  : '/root/del_department',
    component: delDepartment
    },
    {
    path  : '/root/del_station',
    component: delStation
    },
    {
    path  : '/root/del_personnel',
    component: delPersonnel
    },
      {
      path  : '/root/work',
       component: work
      },
      {
        path: '/',
        redirect: '/root/add_department'
      },
    ]
    },
    {
      path: '/login',
      component: login,
      children: []
    },
    {
      path: '/register',
      component: Register,
      children: []
    },
    {
      path: '/',
      redirect: '/login'
    },
  ]
})
