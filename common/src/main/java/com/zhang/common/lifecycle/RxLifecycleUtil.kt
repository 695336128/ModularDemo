package com.zhang.common.lifecycle

import com.trello.rxlifecycle3.LifecycleTransformer
import com.trello.rxlifecycle3.RxLifecycle

/**
 * Created by zhang .
 * DATA: 2019/1/18 .
 * Description : 使用此类操作 RxLifecycle 的特性
 */
object RxLifecycleUtil{

//    fun <T> bindUntilEvent(view: BaseView,event: ActivityEvent): LifecycleTransformer<T>{
//        if (view is ActivityLifecycleable){
//            return
//        }
//    }


    /**
     * 绑定生命周期
     */
    fun <T,R> bindUntilEvent(lifecycleable: Lifecycleable<R>,event: R): LifecycleTransformer<T> = RxLifecycle.bindUntilEvent(lifecycleable.provideLifecycleSubject(),event)

//    fun <T> bindToLifecycle(view: BaseView){
//        if (view is Lifecycleable<*>){
//            return bindToLifecycle(view)
//        }
//    }

//    fun <T> bindToLifecycle(lifecycleable: Lifecycleable<T>): LifecycleTransforme r<T>{
//        when(lifecycleable){
//            is ActivityLifecycleable -> RxLifecycleAndroid.bindActivity(lifecycleable as ActivityLifecycleable)
//        }
//    }
}