import Vue from 'vue'
import VueRouter from 'vue-router'
import Register from '../components/Register'
import Welcome from "@/components/Welcome";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: Register
  },
  {
    path: '/Register',
    name: 'Register',
    component: Register
  },
  {
    path: '/Welcome',
    name: 'Welcome',
    component: Welcome
  }
]

const router = new VueRouter({
  routes
})

export default router
