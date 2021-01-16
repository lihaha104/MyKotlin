package com.example.shop.adpter.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shop.BR

import com.example.shop.R
import com.example.shop.bean.home.HomeData
import com.shop.base.BaseViewHolder
import kotlinx.android.synthetic.main.layout_brand_item.view.*

class HomeBrandAdpter(var context: Context?, var list: List<HomeData.Brand>) :
    RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                viewType,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val dataBinding = holder.dataBinding
        //把数据绑定到item的xml界面
        dataBinding.setVariable(BR.home_brand, list.get(position))
        with(holder?.itemView) {
            Glide.with(context).load(list.get(position).new_pic_url).into(img)
            txt_brand_price.setText(list.get(position).floor_price + "元起")

        }

    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.layout_brand_item
    }

    /**
     * 加载完数据刷新到界面的data
     */
    fun refreshData(lt: List<HomeData.Brand>) {
        list = lt
        notifyDataSetChanged()
    }
}