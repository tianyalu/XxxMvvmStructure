# `MVVM`项目搭建

[TOC]

## 前言

构建项目时我们需要考虑的原则： 模块化、层次化、控件化、组件化。

组件化的作用：解耦、减小apk的大小、降低维护的难度、方便测试等等。可以参考下图：

![image](https://github.com/tianyalu/XxxMvvmStructure/raw/master/show/project_module_structure.png)

## 一、搭建自己的本地构建仓库

### 1.1 本地构建仓库的优势

鉴于中国特色的“网络墙”，我们访问国外的远程仓库极慢，而且面临下载时间长、容易中断甚至完全下载不了等痛点。构建自己的本地仓库能够很好地解决这些问题：首先我们的本地仓库依赖阿里云镜像仓库，可以绕过“网络墙”问题；其次我们可以发布自己的组件库到本地仓库中，方便团队协作；同时本地仓库还可以支持多域名、多环境。

本地构建仓库拓扑结构如下图所示：  

![image](https://github.com/tianyalu/XxxMvvmStructure/raw/master/show/local_repository_structure.png)  

### 1.2 本地构建仓库搭建过程

那么如何搭建自己的本地仓库呢？有如下两款软件可供选择：

> 1. `nexus`：仅支持`Java`;
> 2. `Artifactory Pro`：几乎支持所有的语言。

基于支持范围考虑，我们选择`Artifactory Pro`。本文使用的是 [6.6破解版](https://pan.baidu.com/s/1cCkrmqM4D8GnI210EYLKCw ) ( ybyj )，在`resources`目录下有说明文档。

#### 1.2.1 添加远程代理仓库

![image](https://github.com/tianyalu/XxxMvvmStructure/raw/master/show/artifactory/remote_repository1.png)  

![image](https://github.com/tianyalu/XxxMvvmStructure/raw/master/show/artifactory/remote_repository2.png)  

![image](https://github.com/tianyalu/XxxMvvmStructure/raw/master/show/artifactory/remote_repository3.png)  

![image](https://github.com/tianyalu/XxxMvvmStructure/raw/master/show/artifactory/remote_repository4.png)  

![image](https://github.com/tianyalu/XxxMvvmStructure/raw/master/show/artifactory/remote_repository5.png)  

#### 1.2.2 添加本地仓库

![image](https://github.com/tianyalu/XxxMvvmStructure/raw/master/show/artifactory/local_repository1.png)  

![image](https://github.com/tianyalu/XxxMvvmStructure/raw/master/show/artifactory/local_repository2.png)  

#### 1.2.3 添加仓库组

![image](https://github.com/tianyalu/XxxMvvmStructure/raw/master/show/artifactory/repository_group1.png)  

![image](https://github.com/tianyalu/XxxMvvmStructure/raw/master/show/artifactory/repository_group2.png)  

![image](https://github.com/tianyalu/XxxMvvmStructure/raw/master/show/artifactory/repository_group3.png)  

#### 1.2.4 配置`gradle`文件

**仓库路径含义：**

> 1. `buildscript`下的：告诉`gradle`如何构建打包生成`apk`；
> 2. `allprojects`下的：我们的源码以及我们引用别人源码的依赖下载地址。

```groovy
buildscript {
    repositories {
        maven {
            url 'http://localhost:8081/artifactory/android_group/'
        }
        google()
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.5.2'
        classpath "com.alibaba:arouter-register:1.0.2"
    }
}

allprojects {
    repositories {
        maven {
            url 'http://localhost:8081/artifactory/android_group/'
        }
        google()
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
```

#### 1.2.5 部署`gradle`文件

我们可以将某些版本的`gradle`文件部署到本地仓库，避免花费大量时间从远程下载。

![image](https://github.com/tianyalu/XxxMvvmStructure/raw/master/show/artifactory/deploy_gradle1.png)  

当提示`File size exceeds the limit of 100 MB`时我们可以修改配置： 

![image](https://github.com/tianyalu/XxxMvvmStructure/raw/master/show/artifactory/deploy_gradle2.png)  

![image](https://github.com/tianyalu/XxxMvvmStructure/raw/master/show/artifactory/deploy_gradle3.png)  

#### 1.2.5 修改`gradle`依赖地址

修改`gradle-wrapper.properties`文件：

```groovy
#Fri Jul 17 20:50:34 CST 2020
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
#distributionUrl=https\://services.gradle.org/distributions/gradle-5.4.1-all.zip
distributionUrl=https\://localhost:8081/artifactory/android_local/gradle-5.4.1-all.zip
```

## 二、搭建网络模块

`Retrofit + OKHttp + RxJava` 实现的网络请求流程如下图所示：

![image](https://github.com/tianyalu/XxxMvvmStructure/raw/master/show/network_request_process.png)



Okhttp 原理

![image](https://github.com/tianyalu/XxxMvvmStructure/raw/master/show/okhttp_theory.png)



报错：  

```java
CLEARTEXT communication to service-o5ikp40z-1255468759.ap-shanghai.apigateway.myqcloud.com not permitted by network security policy
```

Xml --> network_security_config.xml

AndroidManifest.xml --> application:android:networkSecurityConfig="@xml/network_security_config"





2. 控件化+Mvvm（m）vm+v

适配器模式：将数据适配到View

单一职责原则

开闭原则

可读 可修改

base 高级/架构师 才能修改

common 通用的功能或者View 所有人都能改



![image-20200720222121879](/Users/tian/Library/Application Support/typora-user-images/image-20200720222121879.png)

Model需要考虑的问题：  

![image-20200721093304920](/Users/tian/Library/Application Support/typora-user-images/image-20200721093304920.png)

架构师：

> 1. 对产品负责，对需求、技术选型负责 native/flutter/html/hybrid/小程序  
> 2. 对程序员负责，通过技术管理团队，服务意识，扎实的基本功：设计模式+语言功底 基本功 控件化+四大组件+自定义View  
> 3. 对痛点/难点负责 优化负责  oom/anr/耗电/卡顿 一系列的问题都需要处理

3. 内容优化（启动优化）

Lifecycle owner model

Mvvm m vm v 的创建顺序：v-->vm-->m

数据库：room+paging+livedata<PagingList<D>> 数据库的数据

![image-20200721101327415](/Users/tian/Library/Application Support/typora-user-images/image-20200721101327415.png)

分页状态机

![image-20200721101749731](/Users/tian/Library/Application Support/typora-user-images/image-20200721101749731.png)

80% list size=1 list  基于这样的假设       先实现-->优化（提取基类）

loadsir-->view的错误处理

预加载 耗费时间 不希望用

懒加载 网络请求少 提升速度  androidx  setMaxLifecycle  onStart onCreate onResume

组件化的难点：迁移、老工程迁移到组件化、历史代码的迁移

SplashActivity:

splash(带背景)        MainActivity   newsDetailActivity

onStop	                 onResume       体验优先原则

onPause(数据保存)   onCreate         安全第一原则