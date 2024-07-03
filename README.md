项目技术栈 JDK17、Spring Cloud Alibaba、Nacos、Redis、Caffeine、

- PO（Persistent Object）：永久对象，数据库字段一一对应的对象。
- VO（View Object）：显示层对象，通常是 Web 向模板渲染引擎层传输的对象。
- DTO（Data Transfer Object）：数据传输对象，前端像后台/服务间进行传输的对象，类似于param。
- BO（Business Object）：业务对象，内部业务对象，只在内部传递，不对外进行传递。
- FeignClient：微服务之间存在互相调用。
- Controller：对外部访问控制进行转发，各类基本参数校验，或者不复用的业务简单处理等。
- Service 层：相对具体的业务逻辑服务层。
- Manager 层：通用业务处理层，它有如下特征：
    - 1） 对第三方平台封装的层，预处理返回结果及转化异常信息，适配上层接口。
    - 2） 对 Service 层通用能力的下沉，如缓存方案、中间件通用处理。
    - 3） 与 DAO 层交互，对多个 DAO 的组合复用。
- Mapper持久层：数据访问层，与底层 MySQL进行数据交互。

# 目录结构

```
shiyu-cloud
├─shiyu-common -- 公共模块
│  ├─shiyu-common-cache  -- 缓存相关公共代码
│  ├─shiyu-common-core  -- 公共模块核心（公共中的公共代码）
│  ├─shiyu-common-database  -- 数据库连接相关公共代码
│  ├─shiyu-common-rocketmq  -- rocketmq相关公共代码
├─shiyu-feign  -- 接口定义/服务调用
│  ├─shiyu-feign-order  -- 订单接口定义
│  ├─shiyu-feign-product  -- 产品接口定义
│  ├─shiyu-feign-user  -- 用户接口定义
├─shiyu-gatway  -- 网关服务
├─shiyu-order  -- 订单服务
├─shiyu-product  -- 产品服务
└─shiyu-user  -- 用户服务
├─shiyu-multishop  -- 商家端（待实现）
├─shiyu-payment  -- 支付服务（待实现）
├─shiyu-platform  -- 平台端（待实现）
├─shiyu-rbac  -- 用户角色权限模块（待实现）
├─shiyu-search  -- 搜索模块（待实现）
```

# 仓库
## 查看Git仓库
首先查看Git代码绑定了哪些Git仓库

git remote -v

## 添加远程仓库地址
git remote add master https://gitee.com/li21/shiyu-cloud.git

## 绑定多个远端仓库
之后再绑定另外一个远端仓库，使Push的时候能同时Push两个仓库

git remote set-url --add master http://124.222.20.152:3000/shiyu/shiyu-cloud.git

git remote set-url --add master http://github.com/ShiRuYu/shiyu-cloud.git

## 强制覆盖远程仓库
远程分支上存在本地分支中不存在的提交
git push master master -f