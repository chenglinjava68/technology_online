import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

//所有权限通用路由表
//如首页和登录页和一些不用权限的公用页面
export const constantRouterMap = [
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
    path: '/',
    name: 'Home',
    redirect: '/dashboard',
    component: resolve => require(['@/views/Home.vue'], resolve),
    meta: { title: '基础平台' },
    children: [{ path: 'dashboard', component: resolve => require(['@/views/NoFound.vue'], resolve), meta: { title: '系统首页' }},
                { path: 'dashboard1', component: resolve => require(['@/views/NoFound.vue'], resolve), meta: { title: 'test' }}]
  },
]
export const asyncRouterMap = [
  {
    path:'*',
    component : resolve => require(['@/views/NoFound.vue'], resolve)
  },
]
export default new Router({
  mode: 'history',
  routes: constantRouterMap
})
