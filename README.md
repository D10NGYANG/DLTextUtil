# DLTextUtil
字符串、字节数据处理工具[![](https://jitpack.io/v/D10NGYANG/DLTextUtil.svg)](https://jitpack.io/#D10NGYANG/DLTextUtil)

## 使用
1 Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
2 Add the dependency
```gradle
dependencies {
    // 字符串字节数据工具
    implementation 'com.github.D10NGYANG:DLTextUtil:1.0.0-debug2'
    // 协程
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2"
}
```
3 混淆
```properties
-keep class com.d10ng.text.** {*;}
-dontwarn com.d10ng.text.**
```
