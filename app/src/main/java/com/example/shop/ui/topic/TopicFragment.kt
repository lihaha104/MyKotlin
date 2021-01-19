package com.example.shop.ui.topic

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.base.IItemClick
import com.example.shop.R
import com.example.shop.adpter.topic.TopidFragmentAdpter
import com.example.shop.bean.home.TopicData
import com.example.shop.databinding.FragmentTopicBinding
import com.example.shop.viewmodel.topic.TopicViewModel
import com.shop.base.BaseFragment

class TopicFragment():BaseFragment<TopicViewModel,FragmentTopicBinding>(R.layout.fragment_topic,TopicViewModel::class.java)
{
    var mTopic:TopidFragmentAdpter?=null
    override fun initView() {
        mDataBinding!!.up.setOnClickListener {
           mViewModel.getTopic("1")
            top()//回到顶部
        }
        mDataBinding!!.dwon.setOnClickListener {
            mViewModel.getTopic("2")
            top()//回到顶部
        }
    }

    override fun initVM() {
        mViewModel.topic.observe(this, Observer {
           val data = it.data
            initTop(data)

        })
    }



    override fun initData() {
        mViewModel.getTopic("1")


    }

    override fun initVariable() {
    }
    fun initTop(data: List<TopicData.DataX>) {
        mDataBinding!!.topicRcy.layoutManager= LinearLayoutManager(context)
        mDataBinding!!.topicRcy.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
        mTopic=TopidFragmentAdpter(context,data)
        mDataBinding!!.topicRcy.adapter=mTopic
    }

    //把数据回到顶部
    private fun top(){
        mDataBinding!!.nest.fullScroll(View.FOCUS_UP)
    }
    class ItemClick: IItemClick<TopicData.DataX> {
        override fun itemClick(data: TopicData.DataX) {

        }
    }

}