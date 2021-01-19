package com.example.shop.adpter.home

import android.content.Context
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.BR
import com.example.shop.R
import com.example.shop.bean.home.HomeData
import com.shop.base.BaseMyAdapter

class HomeCategoryAdpter(context: Context?,list: List<HomeData.Category>):BaseMyAdapter<HomeData.Category>(context!!,list,
    R.layout.adpter_home_category) {
    override fun layoutId(position: Int): Int {
        return layout
    }

    override fun bindData(binding: ViewDataBinding, data: HomeData.Category) {
        binding.setVariable(BR.home_category,data)
        val rcy = binding.root.findViewById<RecyclerView>(R.id.recy_category)
        rcy.layoutManager= GridLayoutManager(context,2)
        rcy.adapter = HomeCategorySonAdapter(context, data.goodsList)
    }
}