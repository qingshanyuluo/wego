<template>
  <div>
    <el-container>
      <el-header>
        <img src="../assets/logo.jpg" class="logo" alt="">
        <el-menu :default-active="activeIndex" class="nav" mode="horizontal" @select="handleSelect">
          <el-menu-item index="1">报名</el-menu-item>
          <el-menu-item index="2" @click="toNotice" style="color: #666666">
            通知
          </el-menu-item>
        </el-menu>
      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
      <el-footer style="color: #666666">
        ©2020 - 天津工业大学 WeGo 社团
      </el-footer>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "Home",
  components: {

  }
}
</script>

<style scoped>

</style>