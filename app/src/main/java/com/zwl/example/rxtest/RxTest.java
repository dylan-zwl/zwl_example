package com.zwl.example.rxtest;

import android.Manifest;
import android.app.Activity;

import com.orhanobut.logger.Logger;
import com.tbruyelle.rxpermissions2.RxPermissions;


/**
 * Created by Administrator on 2019/3/28.
 */

public class RxTest {
    public static void test(Activity activity) {
        RxPermissions rxPermissions = new RxPermissions(activity);
        rxPermissions.requestEach(Manifest.permission.CAMERA)
                .subscribe(permission -> {
                    if (permission.granted) {
                        Logger.d("用户给权限啦");
                        return;
                    }
                    if (permission.shouldShowRequestPermissionRationale) {
                        Logger.d("用户不给权限");
                        return;
                    }
                    Logger.d("弹窗不显示");
                });
    }

    public static void test2() {
//        Observable(folders)
//                .flatMap(new Func1<File, Observable<File>>() {
//                    @Override
//                    public Observable<File> call(File file) {
//                        return Observable.from(file.listFiles());
//                    }
//                })
//                .filter(new Func1<File, Boolean>() {
//                    @Override
//                    public Boolean call(File file) {
//                        return file.getName().endsWith(".png");
//                    }
//                })
//                .map(new Func1<File, Bitmap>() {
//                    @Override
//                    public Bitmap call(File file) {
//                        return getBitmapFromFile(file);
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Bitmap>() {
//                    @Override
//                    public void call(Bitmap bitmap) {
//                        imageCollectorView.addImage(bitmap);
//                    }
//                });
    }
}
