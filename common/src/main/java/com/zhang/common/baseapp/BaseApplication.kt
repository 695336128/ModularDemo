package com.zhang.common.baseapp

import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.support.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.zhang.common.commonutils.L

/**
 * Created by zhang .
 * DATA: 2018/7/21 .
 * Description : APPLICATION
 */
open class BaseApplication : Application(){

    companion object {
        private var instance: Application? = null

        fun instance() = instance!!

        fun getAppResources(): Resources {
            return instance?.resources!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        ARouter.openDebug()
        ARouter.openLog()
        ARouter.init(this)
        L.init(true)
    }

    /**
     * 分包
     */
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }






}
