package com.example.shop.adpter.topic

import android.content.Context
import android.widget.ImageView
import android.widget.TextView

import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.example.shop.BR


import com.example.shop.R
import com.example.shop.bean.home.TopicData
import com.shop.base.BaseMyAdapter

class TopidFragmentAdpter(context: Context?,list: List<TopicData.DataX>)
    :BaseMyAdapter<TopicData.DataX>(context!!,list,R.layout.adpter_topic) {
    override fun layoutId(position: Int): Int {
        return layout
    }

    override fun bindData(binding: ViewDataBinding, data: TopicData.DataX) {
        binding.setVariable(BR.adpter_topic,data)
        Glide.with(context).load(data.scene_pic_url).into(binding.root.findViewById<ImageView>(R.id.adptertopic_img))

        val price = binding.root.findViewById<TextView>(R.id.adptertopic_price)
        price.setText(data.price_info+"元起")

    }
}