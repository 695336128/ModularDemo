package com.zhang.common.constants

/**
 * Created by zhang .
 * DATA: 2019/1/11 .
 * Description :
 */
object Constants {

    /**
     * 服务器类型
     * SERVER_DEVELOP       开发环境
     * SERVER_TEST          测试环境
     * SERVER_PRODUCTION    生产环境
     */
    val SERVER_TYPE = ServerType.SERVER_DEVELOP

    /**
     * 服务器类型
     */
    object ServerType {
        val SERVER_DEVELOP = 0      //开发环境
        val SERVER_TEST = 1         //测试环境
        val SERVER_PRODUCTION = 2   //生产环境
    }
}