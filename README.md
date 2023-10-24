# DLTextUtil
字符串、字节数据处理工具[![](https://jitpack.io/v/D10NGYANG/DLTextUtil.svg)](https://jitpack.io/#D10NGYANG/DLTextUtil)

# 停止维护⚠️
> 本项目的功能已经合并到[DLCommonUtil](https://github.com/D10NGYANG/DLCommonUtil)中，请跳转查看；

## 使用
1 添加仓库
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://raw.githubusercontent.com/D10NGYANG/maven-repo/main/repository'}
  }
}
```
2 添加依赖
```gradle
dependencies {
    // 字符串字节数据工具
    implementation 'com.github.D10NGYANG:DLTextUtil:1.4.3'
}
```
3 混淆
```properties
-keep class com.d10ng.text.** {*;}
-dontwarn com.d10ng.text.**
```
