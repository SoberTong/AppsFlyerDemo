package com.holaverse.holagames;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        AppsFlyerLib.getInstance().startTracking(this.getApplication(), "fZvuk792H9hJQKmaTwuXxA");

        findViewById(R.id.btn_passLevel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> eventMap = new HashMap<String, Object>();
                eventMap.put(AFInAppEventParameterName.LEVEL, 9);
                eventMap.put(AFInAppEventParameterName.SCORE, 100);
                AppsFlyerLib.getInstance().trackEvent(getApplicationContext(), AFInAppEventType.LEVEL_ACHIEVED, eventMap);
            }
        });

        findViewById(R.id.btn_purchase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put(AFInAppEventParameterName.REVENUE, 200);
                map.put(AFInAppEventParameterName.CONTENT_TYPE, "category_a");
                map.put(AFInAppEventParameterName.CONTENT_ID, "1234567");
                map.put(AFInAppEventParameterName.CURRENCY, "USD");
                AppsFlyerLib.getInstance().trackEvent(getApplicationContext(), AFInAppEventType.PURCHASE, map);
            }
        });

        findViewById(R.id.btn_getAFUID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String appsFlyerId = AppsFlyerLib.getInstance().getAppsFlyerUID(mContext);
                Log.e("SoberTest", appsFlyerId);
                Toast.makeText(mContext, "AFUID:"+appsFlyerId, Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_setUserId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppsFlyerLib.getInstance().setCustomerUserId("Sober123");
            }
        });

        findViewById(R.id.btn_setUserEmail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppsFlyerLib.getInstance().setUserEmails(AppsFlyerProperties.EmailsCryptType.MD5, "438941649@qq.com");
            }
        });
    }
}
