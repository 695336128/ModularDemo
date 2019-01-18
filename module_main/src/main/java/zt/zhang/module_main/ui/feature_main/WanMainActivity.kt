package zt.zhang.module_main.ui.feature_main

import android.os.Bundle
import com.zhang.common.base.BaseActivity
import com.zhang.common.base.BaseModel
import com.zhang.common.base.BasePresenter
import zt.zhang.module_main.R

class WanMainActivity : BaseActivity<BasePresenter<*, *>, BaseModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_wanmain
    }

    override fun initPresenter() {

    }

    override fun initView() {

    }

}
