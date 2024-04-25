import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)
const routes = [ 
  {
    path: '/emp',
    name: 'emp',
    component: function () {
      return import("../views/training/EmpView.vue")
    }
  },
  {
    path: '/dept',
    name: 'dept',
    component: function () {
      return import("../views/training/DeptView.vue")
    }
  },
  {
    path: '/',
    redirect: '/dept'  
  }
]
const router = new VueRouter({
  routes
})

export default router
