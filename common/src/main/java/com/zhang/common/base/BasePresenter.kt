package com.zhang.common.base

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import com.zhang.common.baserx.RxManager

/**
 * Created by zhang .
 * DATA: 2018/7/22 .
 * Description : 基类Presenter
 */
open class BasePresenter<T : BaseView, E: BaseModel>: IPresenter {

    var mModel: E? = null
    var mView: T? = null
    var mRxManage = RxManager()

    fun setVM(v: T, m: E) {
        this.mModel = m
        this.mView = v
    }

    override fun onCreate(owner: LifecycleOwner) {
        println("LifeCycle--- OnCreate")
    }

    override fun onDestory(owner: LifecycleOwner) {
        mRxManage.clear()
        println("LifeCycle--- onDestory")
    }

    override fun onLifecycleChanged(owner: LifecycleOwner, event: OnLifecycleEvent) {
    }

}