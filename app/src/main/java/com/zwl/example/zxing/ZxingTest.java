package com.zwl.example.zxing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;
import com.yzq.zxinglibrary.encode.CodeCreator;
import com.zwl.example.R;

/**
 * Created by Administrator on 2019/3/29.
 */

public class ZxingTest {

    public static void test(Activity activity, int requestCode) {
        Intent intent = new Intent(activity, CaptureActivity.class);
                                /*ZxingConfig是配置类
                                 *可以设置是否显示底部布局，闪光灯，相册，
                                 * 是否播放提示音  震动
                                 * 设置扫描框颜色等
                                 * 也可以不传这个参数
                                 * */
        ZxingConfig config = new ZxingConfig();
//         config.setPlayBeep(false);//是否播放扫描声音 默认为true
//          config.setShake(false);//是否震动  默认为true
//         config.setDecodeBarCode(false);//是否扫描条形码 默认为true
//        config.setReactColor(R.color.colorAccent);//设置扫描框四个角的颜色 默认为白色
//        config.setFrameLineColor(R.color.colorAccent);//设置扫描框边框颜色 默认无色
//        config.setScanLineColor(R.color.colorAccent);//设置扫描线的颜色 默认白色
        config.setFullScreenScan(false);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
        intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
        activity.startActivityForResult(intent, requestCode);
    }

    public static void createQRCode(Context context, String contentEtString) {
        Bitmap logo = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
        Bitmap bitmap = CodeCreator.createQRCode(contentEtString, 400, 400, logo);
    }
}
