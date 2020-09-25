# wego
前端项目 wego-web
后端项目 wego-server

开发环境启动 启动前端在8080端口 后端8081

部署，将前端build后放在nginx 80端口 后端api启动在8081端口
nginx 配置将/api开头的请求转发给8081端口



## 接口：

* post：
  * /register： 
    * 前端：{ “name”: "" , "password":"", "class":"","student_id":"","qq_number":"","email":"","self_introduction":"","verification_code":""}
    *  后端：{"code":"","message":""}

* get:
  * /verify：
    * 后端：验证码图片

