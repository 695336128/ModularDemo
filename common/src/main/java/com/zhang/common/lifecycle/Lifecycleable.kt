package com.zhang.common.lifecycle

import io.reactivex.subjects.Subject

/**
 * Created by zhang .
 * DATA: 2019/1/18 .
 * Description : 让 Activity 和 Fragment 实现此接口，即可正常使用 {@link RxLifecycle}
 * 无需再集成 {@link RxLifecycle} 提供的 Activity/Fragment
 *
 * @see
 */
interface Lifecycleable<E> {
    fun provideLifecycleSubject():Subject<E>
}