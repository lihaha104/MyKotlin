package com.example.shop.adpter.home

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.example.shop.BR
import com.example.shop.R
import com.example.shop.bean.home.GoodsData
import com.shop.base.BaseMyAdapter

class HomeNewGoodsTitleAdpter(context: Context?,list: List<GoodsData.DataX>)
    :BaseMyAdapter<GoodsData.DataX>(context!!,list, R.layout.adpter_home_newgoods_title
) {
    override fun layoutId(position: Int): Int {
        return layout
    }

    override fun bindData(binding: ViewDataBinding, data: GoodsData.DataX) {
        binding.setVariable(BR.adpter_home_newgoods_title,data)
        Glide.with(context).load(data.list_pic_url).into(binding.root.findViewById<ImageView>(R.id.img_newgood_title))
        val price = binding.root.findViewById<TextView>(R.id.txt_newgood_price_title)
        price.setText("￥"+data.retail_price)
    }
}