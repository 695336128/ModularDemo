package zt.zhang.test.ui.test

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.zhang.common.base.BaseActivity
import com.zhang.common.commonutils.ARouterUtil
import com.zhang.common.commonutils.L
import com.zhang.common.constants.ARouterConfig
import kotlinx.android.synthetic.main.activity_test.*
import zt.zhang.test.R



/**
 * Created by zhang .
 * DATA: 2018/7/26 .
 * Description :
 */

@Route(path = ARouterConfig.TEST_ACTIVITY)
class TestActivity : BaseActivity<TestPresenter, TestModel>(), TestContract.View {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_test
    }

    override fun initPresenter() {
        mPresenter?.setVM(this, mModel!!)
    }

    override fun initView() {
        request_button.setOnClickListener { mPresenter?.loadDataRequest() }
        theme_button.setOnClickListener { initTheme(AppCompatDelegate.MODE_NIGHT_YES) }
        jump_button.setOnClickListener {ARouterUtil.startActivityWithParamsForResult(this@TestActivity,ARouterConfig.TEST_ACTIVITY2, mapOf("name" to "zhang"),1001)}
    }

    @SuppressLint("SetTextI18n")
    override fun doWithData(data: TestBean) {
        result_tv.text = "name: ${data.name} \n url: ${data.url}"
        L.d("name: ${data.name} \n url: ${data.url}")
    }

    override fun doWithEvent(data: TestBean) {
        Toast.makeText(mContext, "GetEvevt", Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        startProgressDialog()
    }

    override fun stopLoading() {
        stopProgressDialog()
    }

    override fun showErrorTip(msg: String) {
        showToast(msg)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 1001){
            println(data?.getStringExtra("result"))
        }
    }

}