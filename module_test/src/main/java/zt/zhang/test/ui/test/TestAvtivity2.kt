package zt.zhang.test.ui.test

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.zhang.common.base.BaseActivity
import com.zhang.common.base.BaseModel
import com.zhang.common.base.BasePresenter
import com.zhang.common.constants.ARouterConfig
import kotlinx.android.synthetic.main.activity_test2.*
import zt.zhang.test.R

/**
 * Created by zhang .
 * DATA: 2018/8/7 .
 * Description :
 */

@Route(path = ARouterConfig.TEST_ACTIVITY2)
class TestAvtivity2: BaseActivity<BasePresenter<*,*>, BaseModel>() {

    @JvmField
    @Autowired
    var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_test2
    }

    override fun initPresenter() {
    }

    override fun initView() {
        backBtn.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result","界面2传回来的信息")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        rxBusBtn.setOnClickListener { mRxManager?.post("发送出一个RxBus") }
    }
}