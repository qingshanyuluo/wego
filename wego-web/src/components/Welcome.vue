<template>
  <div>
    <el-container>
      <el-header>
        <img src="../assets/logo.jpg" class="logo" alt="">
        <el-menu :default-active="activeIndex" class="nav" mode="horizontal" @select="handleSelect">
          <el-menu-item index="1" @click="toRegister" style="color: #666666">
            报名
          </el-menu-item>
          <el-menu-item index="2">
            通知
          </el-menu-item>
        </el-menu>
      </el-header>
      <el-main>
        <el-row :gutter="20">
          <el-col :xs="0" :sm="2" :md="3" :lg="3" :xl="3">
            <div class="grid-content"></div>
          </el-col>
          <el-col :xs="24" :sm="20" :md="18" :lg="18" :xl="18">
            <el-card class="r-card">
              <h1>暂无通知</h1>
            </el-card>
          </el-col>
          <el-col :xs="0" :sm="2" :md="3" :lg="3" :xl="3">
            <div class="grid-content"></div>
          </el-col>
        </el-row>
      </el-main>
      <el-footer>
        ©2020 - 天津工业大学 WeGo 社团
      </el-footer>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "welcome",
    data () {
    return {
      activeIndex: '2',
    }
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    toRegister() {
      this.$router.push("/register");
    }
  }
}
</script>

<style scoped>
.el-header {
  line-height: 60px;
  background: rgba(172, 225, 249, 1);
  color: white;
  font-size: 20px;
  display: flex;
  align-content: center;
}

.logo {
  height: 98%;
}

.nav {
  background: rgba(172, 225, 249, 1);
}

.el-main {
  background-image: linear-gradient(to top, rgba(255, 241, 235, 1) 0%, rgba(172, 225, 249, 1) 100%);
  min-height: 1000px;
  height: auto;
}

.el-footer {
  background: rgba(255, 241, 235, 1);
  text-align: center;
  line-height: 60px;
}

.el-row {
  margin-bottom: 20px;
}

.el-col {
  border-radius: 4px;
}

.r-card {
  margin-top: 5%;
  padding: 40px;
  background-color: rgba(249, 250, 252, 0.90);
}

.grid-content {
  border-radius: 4px;
  min-width: 100px;
  min-height: 36px;
}
</style>