# AppsFlyerDemo
# AppsFlyer接入文档：[前往](https://support.appsflyer.com/hc/zh-cn/articles/213335183-)

# 注意事项：

----------
#### 1. v4.6.5版本有个bug，购买验证正确却返回error，该bug在v4.6.6版本已得到修改，所以请使用v4.6.6或以上版本
#### 2. android版本需2.3或以上版本
#### 3. android4.4以上版本获取不到android id和IMEI（小米手机除外）
#### 4. 请一定保证AppsFlyer至少可以获取一个设备唯一标识符(advertising id, android id or IMEI)以进行归因
###### 使用这个版本的SDK, 如果您接了Google Play Services SDK, KitKat4.4和以上操作系统的设备唯一标识符Android ID和IMEI将默认不会被AppsFlyer SDK自动抓取。开发者仍可以通过以下方法向AppsFlyer上报Android ID和IMEI, 注意这两个方法需要放在AppsFlyerLib.getInstance().startTracking(this.getApplication(),"[Dev_Key]")之前
	AppsFlyerLib.getInstance().setImeiData("IMEI_DATA_HERE")
	AppsFlyerLib.getInstance().setAndroidIdData("ANDROID_ID_DATA_HERE")
###### 如果您的应用没有接Google Play Services SDK, 那么IMEI and Android ID默认会被抓取。您也可以通过以下方法禁止Android ID和IMEI被AppsFlyer SDK抓取: 
	AppsFlyerLib.getInstance().setCollectIMEI(false)
	AppsFlyerLib.getInstance().setCollectAndroidID(false)
#### 5. 权限不要忘记
	<uses-permission android:name="android.permission.INTERNET" />
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
	<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
	<uses-permission android:name="android.permission.READ_PHONE_STATE" />
注意：其中READ_PHONE_STATE permission为可选项.添加该权限以激活IMEI追踪(如果现在接入的安卓包是针对除Google Play以外的其他应用商店，那么此权限一定需要声明)
#### 6. 监听器
###### 确保AppsFlyer的监听器置于所有同类监听器第一位，并保证receiver tag在application tag中




### ***打包出现方法数过多的错误，方法数大于65536.解决方法[Android Studio](http://www.jianshu.com/p/5dd2a7a4e6aa)和[eclipse](https://github.com/mmin18/Dex65536)***
