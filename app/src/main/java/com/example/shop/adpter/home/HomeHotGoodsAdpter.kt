package com.example.shop.adpter.home

import android.content.Context
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.example.shop.BR
import com.example.shop.R
import com.example.shop.bean.home.HomeData
import com.shop.base.BaseMyAdapter

class HomeHotGoodsAdpter(context: Context?,list: List<HomeData.HotGoods>):BaseMyAdapter<HomeData.HotGoods>(context!!,list,
    R.layout.adpter_home_hotgoods){
    override fun layoutId(position: Int): Int {
        return  layout
    }

    override fun bindData(binding: ViewDataBinding, data: HomeData.HotGoods) {
       binding.setVariable(BR.home_hotgoods,data)
        Glide.with(context!!).load(data.list_pic_url).into(binding.root.findViewById(R.id.img_hotgood))
        val price = binding.root.findViewById<TextView>(R.id.txt_hotgood_price)
        price.setText("￥"+data.retail_price)
    }
}