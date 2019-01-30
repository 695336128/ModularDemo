package com.zhang.common.lifecycle

import com.trello.rxlifecycle3.android.ActivityEvent

/**
 * Created by zhang .
 * DATA: 2019/1/18 .
 * Description : 让 Activity 实现此接口，即可正常使用 RxLifecycle
 */
interface ActivityLifecycleable: Lifecycleable<ActivityEvent>