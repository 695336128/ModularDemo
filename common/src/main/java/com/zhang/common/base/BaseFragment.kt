package com.zhang.common.base

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhang.common.commonutils.LoadingUtil
import com.zhang.common.commonutils.TUtil
import com.zhang.common.commonutils.ToastUtil

/**
 * Created by zhang .
 * DATA: 2018/7/26 .
 * Description : BaseFragment
 */
abstract class BaseFragment<T: BasePresenter<*,*>,E: BaseModel> : Fragment() {
    var rootView: View? = null
    var mPresenter: T? = null
    var mModel: E? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null){
            rootView = inflater.inflate(getLayoutResource(),container,false)
        }
        mPresenter = TUtil.getT(this,0)
        mModel = TUtil.getT(this,1)
        initPresenter()
        initView()
        return rootView
    }

    // 获取布局文件
    protected abstract fun getLayoutResource(): Int
    // 初始化Presenter
    protected abstract fun initPresenter()
    // 初始化View
    protected abstract fun initView()

    /**
     * 通过Class跳转界面
     */
    fun startActivity(cls: Class<*>) {
        startActivity(cls, null)
    }

    /**
     * 通过Class跳转界面
     */
    fun startActivityForResult(cls: Class<*>, requestCode: Int) {
        startActivityForResult(cls, null, requestCode)
    }

    /**
     * 含有Bundle通过Class跳转界面
     */
    fun startActivityForResult(cls: Class<*>, bundle: Bundle?,
                               requestCode: Int) {
        val intent = Intent()
        intent.setClass(activity, cls)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivityForResult(intent, requestCode)
    }

    /**
     * 含有Bundle通过Class跳转界面
     */
    fun startActivity(cls: Class<*>, bundle: Bundle?) {
        val intent = Intent()
        intent.setClass(activity, cls)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    /**
     * 开启浮动加载进度条
     */
    fun startProgressDialog() {
        LoadingUtil.showLoading(activity!!)
    }

    /**
     * 停止浮动加载进度条
     */
    fun stopProgressDialog() {
        LoadingUtil.hideLoading()
    }

    /**
     * 显示Toast提示(来自String)
     */
    fun showToast(text: String) {
        ToastUtil.showToast(activity!!,text)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (mPresenter != null){
            mPresenter!!.onDestroy()
        }
    }

}