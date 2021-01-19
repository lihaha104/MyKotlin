package com.example.shop.adpter.home

import android.content.Context
import androidx.databinding.ViewDataBinding
import com.example.shop.BR
import com.example.shop.R
import com.example.shop.bean.home.GoodsData
import com.shop.base.BaseMyAdapter

class HomeNewGoodsTitlePwAdpter(context: Context?,list:
List<GoodsData.FilterCategory>):BaseMyAdapter<GoodsData.FilterCategory>(context!!,list,R.layout.adpter_home_newgoods_title_pwadpter){
    override fun layoutId(position: Int): Int {
        return layout
    }

    override fun bindData(binding: ViewDataBinding, data: GoodsData.FilterCategory) {
        binding.setVariable(BR.adpter_home_newgoods_title_pwadpter,data)
    }
}