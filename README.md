# ToastUtil
[![API](https://img.shields.io/badge/API-4%2B-blue.svg)](https://developer.android.com/about/versions/android-1.6.html
)
[![Download](https://img.shields.io/badge/Download-1.0.1-green.svg)](https://bintray.com/gujin/maven/toast-util/_latestVersion)
[![Build Status](https://travis-ci.org/GuJin/ToastUtil.svg?branch=master)](https://travis-ci.org/GuJin/ToastUtil)

Simple ToastUtil for Android.

Download
--------
You can download a jar from GitHub's [releases page][3].

Or use Gradle:
```gradle
compile 'tech.gujin:toast-util:1.0.1'
```

How to use
--------
Initialize in your application class
```java
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtil.initialize(this);
        // replaceable mode
        // ToastUtil.initialize(this, ToastUtil.Mode.REPLACEABLE);
    }
}
```
Register application class in AndroidManifest.xml
```xml
<application
    android:name="yourPackageName.MyApplication"
    ...
</application>      
```
Use
```java
ToastUtil.show("ToastUtil");
```
There are two modes in the util , introduce them through a gif.
- ToastUtil.Mode.NORMAL
- ToastUtil.Mode.REPLACEABLE

![](https://github.com/GuJin/ToastUtil/blob/master/screenshots/mode.gif)


For more information please see the [sample model][1] and [javadocs][2].

License
--------

    Copyright GuJin

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]: https://github.com/GuJin/ToastUtil/tree/master/sample/src/main/java/tech/gujin/toast/sample
[2]: https://gujin.github.io/ToastUtil/javadocs/1.0.1/index.html
[3]: https://github.com/GuJin/ToastUtil/releases
