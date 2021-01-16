package com.example.shop.fragment.home

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shop.R
import com.example.shop.adpter.home.HomeBrandTitleAdpter
import com.example.shop.bean.home.BrandData
import com.example.shop.databinding.ActivityHomeBrandTitleBinding
import com.example.shop.viewmodel.home.HomeBrandViewModel
import com.shop.base.BaseActivity

class HomeBrandTitleActivity :
    BaseActivity<HomeBrandViewModel,ActivityHomeBrandTitleBinding>
        (R.layout.activity_home_brand_title,HomeBrandViewModel::class.java) {
   var page:String="1"
    var mAdpter:HomeBrandTitleAdpter?=null
    override fun initView() {

    }

    override fun initVM() {
        mViewModel.brand.observe(this, Observer {
            initBrand(it.data)

        })
    }

    override fun initData() {
        mViewModel.getBrand(page)
    }

    override fun initVariable() {

    }
    fun initBrand(data: List<BrandData.DataX>) {
        mDataBinding!!.homeBrandTitleRcy.layoutManager=LinearLayoutManager(this)
        mAdpter=HomeBrandTitleAdpter(this,data)
        mDataBinding!!.homeBrandTitleRcy.adapter= mAdpter
    }

}