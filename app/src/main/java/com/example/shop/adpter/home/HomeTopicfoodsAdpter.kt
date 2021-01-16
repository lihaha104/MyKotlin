package com.example.shop.adpter.home

import android.content.Context
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.example.shop.BR
import com.example.shop.R
import com.example.shop.bean.home.HomeData
import com.shop.base.BaseMyAdapter

class HomeTopicfoodsAdpter(context: Context?,list: List<HomeData.Topic>):BaseMyAdapter<HomeData.Topic>(context!!,list,
    R.layout.adpter_home_topic) {
    override fun layoutId(position: Int): Int {
       return R.layout.adpter_home_topic
    }

    override fun bindData(binding: ViewDataBinding, data: HomeData.Topic) {
        binding.setVariable(BR.home_topic,data)
        Glide.with(context!!).load(data.item_pic_url).into(binding.root.findViewById(R.id.img_topic))
        val price = binding.root.findViewById<TextView>(R.id.txt_topic_name)
        price.setText(data.title + "   ￥" + data.price_info + "元起")

    }
}