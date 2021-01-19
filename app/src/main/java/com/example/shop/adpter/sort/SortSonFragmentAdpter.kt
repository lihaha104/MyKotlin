package com.example.shop.adpter.sort
import android.content.Context
import androidx.databinding.ViewDataBinding
import com.example.shop.R
import com.example.shop.bean.sort.SortData
import com.shop.base.BaseMyAdapter

class SortSonFragmentAdpter(context: Context?,list: List<SortData.SubCategory>):BaseMyAdapter<SortData.SubCategory>(context!!,list,
    R.layout.adpter_sort_son_fragment) {
    override fun layoutId(position: Int): Int {
        return layout
    }

    override fun bindData(binding: ViewDataBinding, data: SortData.SubCategory) {
    }
}