package com.example.shop.fragment.home

import android.content.Intent
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shop.R
import com.example.shop.adpter.home.*
import com.example.shop.databinding.FragmentHomeBinding
import com.example.shop.bean.home.HomeData
import com.example.shop.viewmodel.home.HomeViewModel
import com.shop.base.BaseFragment
import com.shop.ui.home.MyBannerAdapter
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment() : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    R.layout.fragment_home,
    HomeViewModel::class.java
) {
    //初始化适配器
    var mBanner: MyBannerAdapter? = null
    var mBrand: HomeBrandAdpter? = null
    var mNewGoods: HomeNewGoodsAdpter? = null
    var mHotGoods: HomeHotGoodsAdpter? = null
    var mTopicfoods: HomeTopicfoodsAdpter? = null
    var mCategory: HomeCategoryAdpter? = null

    //请求数据
    override fun initData() {
        mViewModel.gethome()
    }

    //初始化
    override fun initView() {
        //品牌的跳转
        txt_brand_title.setOnClickListener(View.OnClickListener {
            var intent = Intent(context, HomeBrandTitleActivity::class.java)
            startActivity(intent)
        })
    }

    //绑定数据
    override fun initVM() {
        mViewModel.home.observe(this, Observer {
            initBanner(it.banner) //初始化banner
            initChannel(it.channel)//初始化channel
            initBrand(it.brandList)//初始化Brand
            initNewgoods(it.newGoodsList)//初始化NewGoodsList
            initHotgoods(it.hotGoodsList)//初始化hotGoodsList
            initTopicgoods(it.topicList)//初始化TopicGoodslist
            initCategoryList(it.categoryList)//初始化Categorylist
        })
    }

    override fun initVariable() {

    }

    //初始化banner
    private fun initBanner(banner: List<HomeData.Banner>) {
        //banner
        mBanner = MyBannerAdapter()
        mDataBinding!!.homeBanner.setImages(banner).setImageLoader(mBanner).start()
    }

    //初始化channel
    private fun initChannel(channels: List<HomeData.Channel>) {
        layout_tab.removeAllViews()// 清空所有视图
        val layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
        for (i: Int in channels.indices) {
            val channel = channels.get(i)
            val channelview = LayoutInflater.from(context)
                .inflate(R.layout.layout_channel_item, layout_tab, false)
            val img = channelview.findViewById<ImageView>(R.id.img_channel)
            Glide.with(activity!!).load(channel.icon_url).into(img)
            val text = channelview.findViewById<TextView>(R.id.txt_channel)
            text.setText(channel.name)//设置标题
            text.gravity = Gravity.CENTER//设置字体的位置
            channelview.layoutParams = layoutParams//设置布局
            layout_tab.addView(channelview)//添加布局
            channelview.setTag(channel)
        }
        //监听

    }

    //初始化Brand
    private fun initBrand(brandList: List<HomeData.Brand>) {
        //brand
        mDataBinding!!.recyBrand.layoutManager = GridLayoutManager(activity, 2)
        mBrand = HomeBrandAdpter(context, brandList)
        mDataBinding!!.recyBrand.adapter = mBrand
    }

    //初始化Newgoods
    private fun initNewgoods(newGoodsList: List<HomeData.NewGoods>) {
        mDataBinding!!.recyNewgood.layoutManager = GridLayoutManager(context, 2)
        mNewGoods = HomeNewGoodsAdpter(context, newGoodsList)//创建适配器
        mDataBinding!!.recyNewgood.adapter = mNewGoods//绑定适配器
    }

    //初始化Hotgoods
    private fun initHotgoods(hotGoodsList: List<HomeData.HotGoods>) {
        mDataBinding!!.recyHotgood.layoutManager = LinearLayoutManager(context)
        mHotGoods = HomeHotGoodsAdpter(context, hotGoodsList)
        mDataBinding!!.recyHotgood.adapter = mHotGoods

    }

    //初始化Topicgoods
    private fun initTopicgoods(topicList: List<HomeData.Topic>) {
        mDataBinding!!.recyTopic.layoutManager =
            LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        mTopicfoods = HomeTopicfoodsAdpter(context, topicList)
        recy_topic.adapter = mTopicfoods
    }

    //初始化CategoryList
    private fun initCategoryList(categoryList: List<HomeData.Category>) {

        recy_category.setLayoutManager(object : LinearLayoutManager(context) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        })//不可滚动显示
        mCategory = HomeCategoryAdpter(context, categoryList)
        recy_category.adapter = mCategory
    }

}