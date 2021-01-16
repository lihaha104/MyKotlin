package com.shop.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shop.base.interfaces.IBaseView


/**
 * baseActivity基类
 */
abstract class BaseActivity<VM:BaseViewModel,DB:ViewDataBinding>(var layoutId:Int,val vmClass:Class<VM>):AppCompatActivity(),IBaseView {

    protected lateinit var mViewModel:VM
    protected lateinit var mDataBinding:DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView(this,layoutId)
        mViewModel = ViewModelProvider(this).get(vmClass)
        initView()
        initVM()
        initData()
        initVariable()
    }

    protected abstract fun initView()
    protected abstract fun initVM()
    protected abstract fun initData()
    protected abstract fun initVariable()

    override fun showLoading(visible: Int) {
        TODO("Not yet implemented")
    }

    override fun dissLoading(tips: String) {
        TODO("Not yet implemented")
    }






}