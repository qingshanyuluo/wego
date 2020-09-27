<template>
  <div>
    <el-container>
      <el-header>
        <img src="../assets/logo.jpg" class="logo" alt="">
        <el-menu :default-active="activeIndex" class="nav" mode="horizontal" @select="handleSelect">
          <el-menu-item index="1" @click="toRegister" style="color: #666666; font-size: 1rem; padding: 0 0.5rem">
            报名
          </el-menu-item>
          <el-menu-item index="2" @click="toNotice" style="color: #666666; font-size: 1rem; padding: 0 0.5rem">
            通知
          </el-menu-item >
          <el-menu-item index="3" style="float: right; font-size: 1rem; padding: 0 0.5rem">
            关于
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
              <div slot="header" class="clearfix">
                <span style="font-size: 34px"><b>社团介绍</b></span>
              </div>
              <p style="font-size: 20px">wego是天工大计算机学院由学生自发创立，自主运营的计算机技术型社团，秉承多元开放的理念，旨在帮助小白冲破障碍，提高水平。</p>
              <br>
              <h2>零基础小白？</h2>
              <p style="font-size: 20px">wego欢迎各位零基础新生加入，社团会尽一切可能，用想到的最佳方式帮助你们入门。</p>
              <h2>培养的学习方向</h2>
              <p style="font-size: 20px">
                在入门了编程之后，无论你是想写网页、App、小程序，或者是专注于后端假设服务器、处理数据、优化性能，无论是想学习C/C++、Java、JavaScript、python亦或是go、rust等新型语言。都有前辈帮助你，给你指明一条正确的道路。
              </p>
              <h2>讲课形式</h2>
              <p style="font-size: 20px">我们会每周寻找一个大家都空闲的时间开设公开课，不会像老师、或者网上搜索到的详细教程一样一步步教你常规的内容。相反，我们力求我们讲课的内容是你们再任何其他地方都听不到的。</p>
              <h1 style="font-size: 30px">欢迎加入wego！</h1>
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
  name: "about",
  data () {
    return {
      activeIndex: '3',
    }
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    toRegister() {
      this.$router.push("/register");
    },
    toNotice() {
      this.$router.push("/notice");
    },
  }
}
</script>

<style scoped>
.el-header {
  line-height: 60px;
  /*background: rgba(172, 225, 249, 1);*/
  color: white;
  font-size: 20px;
  display: flex;
  align-content: center;
}

.logo {
  height: 98%;
}

.nav {
  width: 100%;
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