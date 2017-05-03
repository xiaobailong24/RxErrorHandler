# RxErrorHandler
[![JitPack](https://jitpack.io/v/xiaobailong24/RxErrorHandler.svg)](https://jitpack.io/#xiaobailong24/RxErrorHandler)
[ ![API](https://img.shields.io/badge/API-15%2B-blue.svg?style=flat-square) ](https://developer.android.com/about/versions/android-4.0.3.html)
[ ![License](http://img.shields.io/badge/License-Apache%202.0-blue.svg?style=flat-square) ](http://www.apache.org/licenses/LICENSE-2.0)

## Error Handle Of Rxjava2
Forked from [JessYanCoding/RxErrorHandler](https://github.com/JessYanCoding/RxErrorHandler) to using RxJava2.

## Step 1
Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

## Step 2
Add the dependency:
```
  dependencies {
  	        compile 'com.github.xiaobailong24:RxErrorHandler:2.0.0'
  	}
```
## Step 3
```
  RxErrorHandler rxErrorHandler = RxErrorHandler
                  .builder()
                  .with(this)
                  .responseErrorListener((context, e) ->
                          Log.w(TAG, "error handle"))
                  .build();
```


## Step 4
```
  Observable
          .error(new Exception("error"))
          .retryWhen(new RetryWithDelay(3, 2))//retry(http connect timeout)
          .subscribe(new ErrorHandleSubscriber<Object>(rxErrorHandler) {
              @Override
              public void onNext(Object o) {
                  Log.d(TAG, "onNext: ");
              }
          });
```

## More
- [Simple Use](https://github.com/xiaobailong24/RxErrorHandler/blob/rxjava2/demo/src/main/java/me/xiaobailong24/rxerrorhandler/demo/MainActivity.java)
- [More](https://github.com/xiaobailong24/MVPArms)

## Thanks
- [JessYanCoding](https://github.com/JessYanCoding)

## License
```
 Copyright 2017, jessyan & xiaobailong24

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
