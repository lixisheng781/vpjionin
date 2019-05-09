### 项目结构
```
├─vpclub
│  │  
│  ├─bom------------公共模块的pom申明
│  │ 
│  ├─common-gateway--------------网关中心
│  │
│  ├─common-eureka---------------注册中心
│  │
│  │
│  ├─common----------------通用模版
│  │    ├─common-model------------------------通用模型模块
│  │    ├─common-util-------------------------通用工具模块
│  │    ├─common-web-api----------------------公共api模块
│  │    └─common-web-provider-----------------公共provider模块
│  │ 
│  ├─feign-----------------服务消费者
│  │    ├─common-feign----------------------通用消费者模块
│  │    └─
│  │ 
│  ├─service-provider-----服务提供者
│  │    ├─boot-provider----------------------启动入口
│  │    ├─admin-provider------------------管理配置信息服务
│  │    ├─activitybaseinfo-provider------------------活动基础信息服务
│  │    ├─activitycheckinfo-provider------------------活动签到报名服务
│  │    └─
│  │
│  ├─web-api-------------对外接口
│  │    ├─boot-api-----------------------启动入口
│  │    ├─admin-api-------------------管理配置信息服务接口
│  │    ├─activitybaseinfo-api------------------活动基础信息接口
│  │    ├─activitycheckinfo-api------------------活动签到报名接口
│  │    └─
│  │
│  │
│
```
###端口定义
```

```
###util
```
```

###主要涉及以下技术栈
```
JDK1.8
Spring cloud 基础框架
Mybatis 持久层
Druid 数据链接池
Mybatis-Plus Mybatis插件 官网http://mp.baomidou.com
MySql 数据库
Redis NO数据库
```