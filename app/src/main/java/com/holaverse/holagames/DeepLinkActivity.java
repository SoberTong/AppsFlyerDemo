package com.holaverse.holagames;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.appsflyer.AppsFlyerLib;

/**
 * Created by Holaverse on 2017/1/6.
 */

public class DeepLinkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deeplink);

        Log.e("DeepLinkActivity", "DeepLinkActivity in");

        AppsFlyerLib.getInstance().sendDeepLinkData(this);
        AppsFlyerLib.getInstance().sendPushNotificationData(this);
    }
}
