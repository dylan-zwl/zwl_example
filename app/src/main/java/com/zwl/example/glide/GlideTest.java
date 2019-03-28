package com.zwl.example.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by Administrator on 2019/3/26.
 */

public class GlideTest {

    /**
     * 功能描述 : 圆形图片
     */
    public static void circle(Context context, Object object, ImageView imageView) {
        RequestOptions mRequestOptions = RequestOptions.circleCropTransform()
                .circleCrop()//指定图片的缩放类型为centerCrop （圆形）
                .skipMemoryCache(true)//跳过内存缓存
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
                .diskCacheStrategy(DiskCacheStrategy.DATA)//只缓存原来分辨率的图片
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);//只缓存最终的图片

        Glide.with(context).load(object).apply(mRequestOptions).skipMemoryCache(true).into(imageView);
    }

    public static void Rounded(Context context, Object object, ImageView imageView) {
        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(6);
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);

        Glide.with(context).load(object).apply(options).into(imageView);
    }

    //使用说明  https://muyangmin.github.io/glide-docs-cn/doc/getting-started.html
}
