<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
import Register from './components/Register.vue'
import Welcome from "@/components/Welcome";

function remove() {
  let Loading = document.getElementById("Loading");
  document.body.removeChild(Loading)
}

export default {
  name: 'app',
  created() {
    let Loading = document.getElementById("Loading");
    if (Loading != null) {
      //调整加载时间
      setTimeout(remove, 1000)
    }
  },
  components: {
    Register,
    Welcome
  },
  methods: {

  }
}
</script>

<style>

</style>
