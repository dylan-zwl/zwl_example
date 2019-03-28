package com.zwl.example.eventbus;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2019/3/26.
 */

public class EventBusTest {
    public static void test(Context context) {
        //注册
        EventBus.getDefault().register(context);
    }

    /**
     * 功能描述 : 响应事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleEvent(MessageEvent messageEvent) {

    }

    //实体类
    private class MessageEvent {
    }
}
