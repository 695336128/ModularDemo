package com.zhang.common.base

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import com.zhang.common.baserx.RxManager
import io.reactivex.disposables.Disposable

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

    /**
     * 将 {@link Disposable} 添加到 {@link CompositeDisposable} 中统一管理
     * 在 {@link BasePresenter#onDestory()} 中使用 clear 方法停止正在执行的 RxJava 任务，避免内存泄露
     */
    open fun addDispose(disposable: Disposable){
        mRxManage.add(disposable)
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