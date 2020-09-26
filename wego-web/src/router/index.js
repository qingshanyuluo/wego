import Vue from 'vue'
import VueRouter from 'vue-router'
import Register from '../components/Register'
import Welcome from "@/components/Welcome";
import Notice from "@/components/Notice";
import About from "@/components/About";

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
    path: '/Notice',
    name: 'Notice',
    component: Notice
  },
  {
    path: '/Welcome',
    name: 'Welcome',
    component: Welcome
  },
  {
    path: '/About',
    name: 'About',
    component: About
  }
]

const router = new VueRouter({
  routes
})

export default router
