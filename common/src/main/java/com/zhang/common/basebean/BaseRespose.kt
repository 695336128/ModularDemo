package com.zhang.common.basebean

import com.zhang.common.constants.NetConfig
import java.io.Serializable

/**
 * Created by zhang .
 * DATA: 2018/8/3 .
 * Description : 服务器返回的基本数据
 */
open class BaseRespose<T>: Serializable{

    var code: String? = null
    var msg: String? = null
    var data: T? = null

    fun success(): Boolean {
        return NetConfig.Code.REQUEST_SUCCESS_CODE == code
    }

    override fun toString(): String {
        return "BaseRespose(code=$code, msg=$msg, data=$data)"
    }


}