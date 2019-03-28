package com.zwl.example;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Administrator on 2019/3/26.
 */

public class ExampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 如果是在HeapAnalyzer进程里，则返回，因为该进程是专门用来堆内存分析的。
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        //调用LeakCanary.install()的方法来进行必要的初始化工作，来监听内存泄漏
        //Activity
        refWatcher = LeakCanary.install(this);
        //Fragment
        refWatcher.watch(this);
    }

    /**
     * 功能描述 : 用于监听Fragment
     */
    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context) {
        ExampleApplication application = (ExampleApplication) context.getApplicationContext();
        return application.refWatcher;
    }
}
