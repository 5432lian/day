package com.example.lianxi.util;

import android.util.Log;

import com.example.lianxi.Bean.DatasBean;
import com.example.lianxi.dao.DaoMaster;
import com.example.lianxi.dao.DaoSession;
import com.example.lianxi.dao.DatasBeanDao;

public class User {
    private static DaoSession daoSession;

    //查询单条
    public static DatasBean query(DatasBean dbBean){
        daoSession = App.getDaoSession();
        DatasBean unique = daoSession.queryBuilder(DatasBean.class)
                .where(DatasBeanDao.Properties.Title.eq(dbBean.getTitle()))
                .build()
                .unique();
        return unique;
    }

    private static final String TAG = "DbUse";
    //插入
    public static  void insert(DatasBean datasBean){
        if (query(datasBean)==null){
            daoSession.insert(datasBean);
        }else{
            Log.d(TAG, "数据已存在");
        }
    }

    //删除
    public static void delete(DatasBean datasBean){
        if (query(datasBean)!=null){
            daoSession.delete(datasBean);
        }else{
            Log.d(TAG, "数据不存在 ");
        }
    }
}
