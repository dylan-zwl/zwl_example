package com.zwl.example;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.leakcanary.LeakCanary;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.zwl.example.log.LogTest;
import com.zwl.example.utils.utils1.ActivityUtils;
import com.zwl.example.zxing.ZxingTest;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LeakCanary.enableDisplayLeakActivity(this);
        LogTest.test();
        RxPermissions permissions = new RxPermissions(this);
        permissions.requestEach(Manifest.permission.CAMERA).subscribe(new Consumer<Permission>() {
            @Override
            public void accept(Permission permission) throws Exception {
                if (permission.granted) {
                    ZxingTest.test(MainActivity.this, 1);
                }
            }
        });
        ActivityUtils.launchActivity(this,"com.johnson","com.johnson.MainActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
