<template>
  <div id="app">
    <router-view  style="height: 100%"></router-view>
  </div>
</template>

<script>
import Register from './components/Register.vue'
import Notice from "@/components/Notice";
import Welcome from "@/components/Welcome";
import About from "@/components/About";

function remove() {
  let Loading = document.getElementById("Loading");
  document.body.removeChild(Loading)
}

export default {
  name: 'app',
  created() {
      setTimeout(remove, 0)
  },
  components: {
    Register,
    Notice,
    Welcome,
    About
  },
  methods: {

  }
}
</script>

<style>

</style>
