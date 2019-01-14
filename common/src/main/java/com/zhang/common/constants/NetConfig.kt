package com.zhang.common.constants

/**
 * Created by zhang .
 * DATA: 2019/1/11 .
 * Description : 网络请求相关配置
 */
object NetConfig {

    /**
     * 请求返回的响应码
     */
    object Code{
        /** 请求成功的响应码*/
        val REQUEST_SUCCESS_CODE = "1000"
        val REQUEST_ERROR_CODE = "0"
    }

    /**
     * 服务器地址
     */
    internal interface BaseUrl {
        companion object {
            val SERVER_DEVELOP = "http://www.wanandroid.com"
            val SERVER_TEST = ""
            val SERVER_PRODUCTION = ""
        }
    }

    /**
     * 返回服务器基础地址
     */
    fun getBaseUrl(): String{
        return when(Constants.SERVER_TYPE){
            Constants.ServerType.SERVER_DEVELOP -> BaseUrl.SERVER_DEVELOP
            Constants.ServerType.SERVER_TEST -> BaseUrl.SERVER_TEST
            Constants.ServerType.SERVER_PRODUCTION -> BaseUrl.SERVER_PRODUCTION
            else -> BaseUrl.SERVER_PRODUCTION
        }
    }



}