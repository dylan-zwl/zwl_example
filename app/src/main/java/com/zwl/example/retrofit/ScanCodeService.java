package com.zwl.example.retrofit;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;


/**
 * Created by Administrator on 2018/1/15.
 */

public interface ScanCodeService {

    @FormUrlEncoded
    @POST()
    Observable<ResponseBody> commonRequest(@Url String url, @FieldMap Map<String, Object> map);

    //刷卡打开接口    @FormUrlEncoded
    @FormUrlEncoded
    @POST("rfidopen")
    Observable<ResponseBody> rfidOpen(@Field("device_id") String deviceId, @Field("rfid_number") String rfidNumber);

    // @Body 标签只能使用post方式
    @POST("user")
    Observable<ResponseBody> getUser(@Body User user);

    class User {
    }

    //使用方法详解  https://www.jianshu.com/p/bf884248cb37
}
