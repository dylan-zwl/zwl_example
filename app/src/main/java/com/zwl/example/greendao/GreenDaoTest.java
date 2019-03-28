package com.zwl.example.greendao;

import android.content.Context;

/**
 * Created by Administrator on 2019/3/26.
 */

public class GreenDaoTest {

    public static void test(Context context) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "test.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();

        UserDao userDao = daoSession.getUserDao();
        userDao.insert(new User());
    }
}
