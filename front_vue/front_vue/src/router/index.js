import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: {
        name: 'Home'
      }
    },
    {
      path: '/',
      name: 'Home',
      component: resolve => require(['@/views/Home.vue'], resolve),
      meta: { title: '基础平台' },
    },
    {
      path: '/login',
      name: 'Login',
      component: resolve => require(['@/views/Login.vue'], resolve)
    },
    {
      path: '/register',
      name: 'Register',
      component: resolve => require(['@/views/Register.vue'], resolve)
    },
    {
      path:'*',
      component : resolve => require(['@/views/NoFound.vue'], resolve)
    },
  ]
})
