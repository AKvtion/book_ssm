# 新华书店 ssm项目
### 后端技术栈

Spring Springmvc Mybatis MySQL JDBC log4j

### 前端

Jsp Bootstrap jQuery EL Jstl



### 运行须知

1. 数据库使用MySQL,在项目启动前需要提前创建好数据库ssm_ebook
   可通过执行sql导入数据，提前完成所有建表和插入数据的操作



2. 修改config.properties

```
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/ssm_ebook?useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false
jdbc.username=root
jdbc.password=root
```



3. 修改上传路径

```java
# 书籍文件和封面文件存放路径
book_path = G:/JavaWeb/project/JavaEEBeKeYe/book/doc/ebooks/
book_cover_path = G:/JavaWeb/project/JavaEEBeKeYe/book/doc/bookCovers/
```


### 实现功能

1. 用户登录注册
2. 用户上传下载书籍
3. 管理员对书籍和用户增删查改
4. 游客浏览书籍
5. 用户可以修改个人资料
6. 用户可以反馈信息
