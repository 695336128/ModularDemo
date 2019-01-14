package com.zhang.common.commonutils

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.zhang.common.basebean.BaseBean

/**
 * Created by zhang .
 * DATA: 2019/1/11 .
 * Description : ARouter 帮助类
 */
object ARouterUtil {

    /**
     * 根据path返回Fragment
     *
     * @param path path
     * @return fragment
     */
    fun getFragment(path: String): Fragment {
        return ARouter.getInstance()
                .build(path)
                .navigation() as Fragment
    }

    /**
     * 根据path返回Activity
     *
     * @param path path
     * @return Activity
     */
    fun getActivity(path: String): Activity {
        return ARouter.getInstance()
                .build(path)
                .navigation() as Activity
    }

    /**
     * ARouter应用内简单跳转界面
     *
     * @param path path or uri
     */
    fun startActivity(path: String) {
        ARouter.getInstance().build(path).navigation()
    }

    /**
     * ARouter跳转界面需要返回值
     *
     * @param activity
     * @param path path or uri
     * @param requestCode 请求标志位
     */
    fun startActivityForResult(activity: Activity,path: String,requestCode: Int) {
        ARouter.getInstance().build(path).navigation(activity,requestCode)
    }


    /**
     * ARouter带Bundle的页面跳转
     *
     * @param path path or uri
     * @param bundle Bundle参数
     */
    fun startActivityWithBundle(path: String,bundle: Bundle){
        ARouter.getInstance().build(path).with(bundle).navigation()
    }

    /**
     * ARouter带参数跳转页面
     *
     * @param path path or uri
     * @param params 参数
     */
    fun startActivityWithParams(path: String, params: Map<String, *>) {
        val postcard = ARouter.getInstance().build(path)
        for (entry in params.entries) {
            val key = entry.key
            val value = params.getValue(key)
            if (value is String) {
                println("数据是String")
                postcard.withString(key, value)
            } else if (value is Boolean) {
                postcard.withBoolean(key, value)
            } else if (value is Int) {
                postcard.withInt(key, value)
            } else if (value is Float) {
                postcard.withFloat(key, value)
            } else if (value is Double) {
                postcard.withDouble(key, value)
            } else if (value is Long) {
                postcard.withLong(key, value)
            } else if (value is Short) {
                postcard.withShort(key, value)
            } else if (value is HashMap<*, *>) {
                postcard.withSerializable(key, value)
            } else if (value is Array<*>) {
                postcard.withSerializable(key, value)
            } else if (value is BaseBean){
                postcard.withSerializable(key,value)
            }
        }
        postcard.navigation()
    }

    /**
     * ARouter带参数跳转页面
     *
     * @param path path or uri
     * @param params 参数
     * @param requestCode 请求参数
     */
    fun startActivityWithParamsForResult(activity: Activity,path: String, params: Map<String, *>,requestCode: Int) {
        val postcard = ARouter.getInstance().build(path)
        for (entry in params.entries) {
            val key = entry.key
            val value = params.getValue(key)
            if (value is String) {
                println("数据是String")
                postcard.withString(key, value)
            } else if (value is Boolean) {
                postcard.withBoolean(key, value)
            } else if (value is Int) {
                postcard.withInt(key, value)
            } else if (value is Float) {
                postcard.withFloat(key, value)
            } else if (value is Double) {
                postcard.withDouble(key, value)
            } else if (value is Long) {
                postcard.withLong(key, value)
            } else if (value is Short) {
                postcard.withShort(key, value)
            } else if (value is HashMap<*, *>) {
                postcard.withSerializable(key, value)
            } else if (value is Array<*>) {
                postcard.withSerializable(key, value)
            } else if (value is BaseBean){
                postcard.withSerializable(key,value)
            }
        }
        postcard.navigation(activity,requestCode)
    }


}