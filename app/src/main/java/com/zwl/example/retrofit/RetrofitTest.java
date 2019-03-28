package com.zwl.example.retrofit;

import android.content.Context;

import com.android.module.retrofit.RetrofitClient;
import com.android.module.retrofit.common.ProgressObserver;

import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2019/3/26.
 */

public class RetrofitTest {

    private RetrofitTest() {
    }

    private static void startTest(Context context) {
        //初始化
        RetrofitClient.getInstance().init(context, null);
        //下载文件
        RetrofitClient.getInstance().download("", new ProgressObserver() {
            @Override
            public void onProgress(long progress, long total, boolean done) {

            }

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        RetrofitClient.getInstance().getService(ScanCodeService.class).rfidOpen("", "");
    }

}
