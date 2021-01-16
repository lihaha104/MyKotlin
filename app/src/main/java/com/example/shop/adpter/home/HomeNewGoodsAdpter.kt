package com.example.shop.adpter.home

import android.content.Context
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.example.shop.BR

import com.example.shop.R
import com.example.shop.bean.home.HomeData
import com.shop.base.BaseMyAdapter

class HomeNewGoodsAdpter(context: Context?,list: List<HomeData.NewGoods>):BaseMyAdapter<HomeData.NewGoods>(
    context!!,list,R.layout.adpter_home_newgoods)
{
    override fun layoutId(position: Int): Int {
        return layout
    }

    override fun bindData(binding: ViewDataBinding, data: HomeData.NewGoods) {
        binding.setVariable(BR.home_newgoods,data)
        Glide.with(context).load(data.list_pic_url).into(binding.root.findViewById(R.id.img_newgood))
        val price = binding.root.findViewById<TextView>(R.id.txt_newgood_price)
        price.setText("￥"+data.retail_price)
    }


}