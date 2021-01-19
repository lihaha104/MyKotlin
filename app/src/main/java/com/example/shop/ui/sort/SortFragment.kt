package com.example.shop.ui.sort

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.shop.R
import com.example.shop.adpter.sort.VpAdpter
import com.example.shop.bean.sort.SortTabData
import com.example.shop.databinding.FragmentSortBinding
import com.example.shop.viewmodel.sort.SortViewModel
import com.shop.base.BaseFragment
import java.util.*


class SortFragment : BaseFragment<SortViewModel,FragmentSortBinding>(R.layout.fragment_sort,SortViewModel::class.java) {
    override fun initView() {


    }

    override fun initVM() {
        mViewModel.sorttab.observe(this, Observer {

            initSortTab(it.categoryList)
        })

    }

    private fun initSortTab(categoryList: List<SortTabData.Category>) {



        val fragments = ArrayList<Fragment>()
        val strings = ArrayList<String>()
        for (i in categoryList.indices) {
            val categoryListBean: SortTabData.Category= categoryList.get(i)
            val sortSonFragment:SortSonFragment = SortSonFragment(categoryList.get(i).id)
            fragments.add(sortSonFragment)
            strings.add(categoryListBean.name)
        }
        mDataBinding!!.sortVp.adapter= VpAdpter(childFragmentManager,fragments,strings)
         mDataBinding!!.sortVtab.setupWithViewPager( mDataBinding!!.sortVp)
    }

    override fun initData() {
        mViewModel.getSortTab()
    }

    override fun initVariable() {
    }


}