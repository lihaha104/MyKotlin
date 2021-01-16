package com.example.shop.adpter.home

import android.content.Context
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.example.shop.BR
import com.example.shop.R
import com.example.shop.bean.home.BrandData
import com.shop.base.BaseMyAdapter
import kotlin.coroutines.CoroutineContext

class HomeBrandTitleAdpter(context: Context?,list: List<BrandData.DataX>):
    BaseMyAdapter<BrandData.DataX>(context!!,list, R.layout.adpter_home_brand_title) {
    override fun layoutId(position: Int): Int {
        return layout
    }

    override fun bindData(binding: ViewDataBinding, data: BrandData.DataX) {
        binding.setVariable(BR.adpter_home_brand_title,data)
        Glide.with(context).load(data.app_list_pic_url).into(binding.root.findViewById(R.id.title_img))
        val titlename =binding.root.findViewById<TextView>(R.id.title_name)
        titlename.setText(data.name+ " | ")
        val titlentitlemoney =binding.root.findViewById<TextView>(R.id.title_money)
        titlentitlemoney.setText(data.floor_price+ "元起")

    }
}