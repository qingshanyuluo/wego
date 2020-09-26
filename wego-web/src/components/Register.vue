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
        <transition name="el-fade-in">
          <div class="r-mask" v-show="show">
            <div class="r-mask-main">
              <el-row>
                <el-col :xs="0" :sm="2" :md="8" :lg="8" :xl="8">
                  <div class="grid-content"></div>
                </el-col>
                <el-col :xs="24" :sm="20" :md="8" :lg="8" :xl="8">
                  <img src="../assets/mask-img.png" class="r-mask-img">
                  <el-button @click="show = !show" class="r-mask-btn" type="primary" size="small">点击进入</el-button>
                </el-col>
                <el-col :xs="0" :sm="2" :md="8" :lg="8" :xl="8">
                  <div class="grid-content"></div>
                </el-col>
              </el-row>
            </div>
          </div>
        </transition>
        <el-main>
          <el-row :gutter="20">
            <el-col :xs="0" :sm="2" :md="3" :lg="3" :xl="3">
              <div class="grid-content"></div>
            </el-col>
            <el-col :xs="24" :sm="20" :md="18" :lg="18" :xl="18">
              <el-card class="r-card">
                <div class="grid-content">
                  <el-form :model="applyForm" :rules="rules" ref="applyForm" label-width="100px" label-position="top">
                    <el-form-item label="姓名" prop="name">
                      <el-input v-model="applyForm.name" placeholder="请输入个人姓名"></el-input>
                    </el-form-item>
                    <el-form-item label="学号" prop="student_id">
                      <el-input v-model="applyForm.student_id" placeholder="请输入个人学号"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                      <el-input type="password" v-model="applyForm.password" placeholder="请输入登录密码" auto-complete="new-password"></el-input>
                    </el-form-item>
                    <el-form-item label="确认密码" prop="check_password">
                      <el-input type="password" v-model="applyForm.check_password" placeholder="请再次输入确认登录密码" auto-complete="new-password"></el-input>
                    </el-form-item>
                    <el-form-item label="专业班级（如：计科2xxx）" prop="clazz">
                      <el-input v-model="applyForm.clazz" placeholder="请输入专业班级"></el-input>
                    </el-form-item>
                    <el-form-item label="QQ" prop="qq_number">
                      <el-input v-model="applyForm.qq_number" placeholder="请输入自己用的QQ"></el-input>
                    </el-form-item>
                    <el-form-item label="E-mail" prop="email">
                      <el-input v-model="applyForm.email" placeholder="请输入自己的邮箱"></el-input>
                    </el-form-item>
                    <el-form-item label="一段简短的自我介绍（最能展现个人魅力的自我介绍，能够帮助我们快速认识你）：" prop="self_introduction">
                      <el-input type="textarea" v-model="applyForm.self_introduction"></el-input>
                    </el-form-item>
                    <el-form-item label="验证码" prop="verification_code">
                      <el-col :xs="10" :sm="10" :md="6" :lg="4" :xl="4" style="margin-left: -10px">
                        <el-input v-model="applyForm.verification_code"></el-input>
                      </el-col>
                      <el-col :xs="4" :sm="4" :md="4" :lg="4" :xl="4">
                        <div></div>
                      </el-col>
                      <el-col :xs="10" :sm="10" :md="14" :lg="16" :xl="16" style="height: 40px">
                        <img :src="verify_code" style="float: left; height: 100%" alt="">
                        <el-button type="text" @click="reVerify" style="margin-left: 2px; position: absolute">看不清</el-button>
                      </el-col>
                    </el-form-item>
                    <el-form-item>
                      <el-button type="primary" @click="submitForm('applyForm')" round>提交</el-button>
                    </el-form-item>
                  </el-form>
                </div>
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
  name: "Register",
  created() {
    this.$http.get('/verify', {
      params: '',
      responseType: 'blob' // 必须说明 axios 请求类型
    }).then((res) => {
      this.verification_code = window.URL.createObjectURL(res.data); // 后端返回前端渲染
    }).catch(() => {
      // this.setState({
      //   imgCodeUrl: require('@/assets/imageFail.png') // 默认图片
      // })
    })
  },
  data() {
    let validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.applyForm.check_password !== '') {
          this.$refs.applyForm.validateField('check_password');
        }
        callback();
      }
    };

    let validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.applyForm.password) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    return {
      show: true,
      activeIndex: '1',
      verify_code: '/img/logo.30f51a04.jpg',
      applyForm: {
        name: '',
        password: '',
        check_password: '',
        clazz: '',
        student_id: '',
        qq_number: '',
        email: '',
        self_introduction: '',
        verification_code: ''
      },
      rules: {
        name: [
          {required: true, message: '请输入自己姓名', trigger: 'blur'},
        ],
        password: [
          {required: true, validator: validatePass, trigger: 'blur'}
        ],
        check_password: [
          {required: true, validator: validatePass2, trigger: 'blur'}
        ],
        clazz: [
          {required: true, message: '请输入自己专业', trigger: 'blur'}
        ],
        student_id: [
          {required: true, message: '请输入自己学号', trigger: 'blur'}
        ],
        qq_number: [
          {required: true, message: '请输入自己的QQ', trigger: 'blur'}
        ],
        email: [
          {required: true, message: '请输入自己的邮箱', trigger: 'blur'}
        ],
        self_introduction: [
          {required: true, message: '请填写个人简介', trigger: 'blur'}
        ],
        verification_code: [
          {required: true, message: '请输入验证码', trigger: 'blur'}
        ]
      }
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    toNotice() {
      this.$router.push("/welcome");
    },
    submitForm(formName) {
      // this.$router.push("/welcome");
      this.$refs[formName].validate(async (valid) => {
        if (!valid) return;
        await this.$http
            .post("/register", this.applyForm)
            .then(res => {
              if (res.status.code === 500) {
                this.$message.error("111")

                console.log(res.status.message);
                // this.$router.push("/welcome");
              } else if (res.data.status === 200) {
                console.log(res.status.message);
              }
            })
            .catch(err => {
              console.log(err);
            });
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    reVerify() {
      this.$http.get('/verify', {
        params: '',
        responseType: 'blob' // 必须说明 axios 请求类型
      }).then((res) => {
        this.verification_code = window.URL.createObjectURL(res.data); // 后端返回前端渲染
      }).catch(() => {
        // this.setState({
        //   imgCodeUrl: require('@/assets/imageFail.png') // 默认图片
        // })
      })
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
  height: 100%;
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

.r-mask {
  position: absolute;
  height: 100%;
  width: 100%;
  z-index: 10;
  margin-top: 60px;
  text-align: center;
  background-image: linear-gradient(to top, rgba(255, 241, 235, 1) 0%, rgba(172, 225, 249, 1) 100%)
}

.r-mask-main {
  margin-top: 8%;
}

.r-mask-img {
  width: 100%;
}

.r-mask-btn {
  margin: 0 auto;
  display: block;
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

.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>