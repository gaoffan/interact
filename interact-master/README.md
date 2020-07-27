# Interactive Teaching for SACC
技术栈：Spring Boot + MySQL(MyBatis) + Redis + Shiro

先配置一下application.properties里面的数据库账号密码，再在本机建立interact数据库（注意编码为utf8mb4），之后启动后会自动进行数据库的迁移（Flyway），建库的sql文件在db/migration下，无需手动导入。

## 大纲

- [ ] 用户管理
  - [ ] 注册
  - [ ] 登录
  - [ ] 忘记密码
  - [ ] 个人中心
  - [ ] 权限控制
- [ ] 首页
- [ ] 组页
  - [ ] 课程显示
  - [ ] 授课签到
  - [ ] 直播课/回放
  - [ ] 作业
    - [ ] 作业布置
    - [ ] 作业上传
    - [ ] 作业查看批改（zip内文件/代码）
    - [ ] 优秀作业展示
  - [ ] 问答
  - [ ] 课件
  - [ ] 教学评价
  - [ ] 课外任务（和作业共用）