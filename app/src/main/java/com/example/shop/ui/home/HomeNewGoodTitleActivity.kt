package com.example.shop.ui.home

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shop.R
import com.example.shop.adpter.home.HomeNewGoodsTitleAdpter
import com.example.shop.adpter.home.HomeNewGoodsTitlePwAdpter
import com.example.shop.bean.home.GoodsData
import com.example.shop.databinding.ActivityHomeNewGoodTitleBinding
import com.example.shop.viewmodel.home.HomeGoodsViewModel
import com.shop.base.BaseActivity


class HomeNewGoodTitleActivity :
    BaseActivity<HomeGoodsViewModel,ActivityHomeNewGoodTitleBinding>(R.layout.activity_home_new_good_title,HomeGoodsViewModel::class.java) {

    private val ASC = "asc"
    private val DESC = "desc"
    private val DEFAULT = "default"
    private val PRICE = "price"

    //网络请求的参数
    private val isNew = 1 //是否是新品
    private val page = 1 //第一页数据
    private var order: String = ASC //排序方式
    private var sort:String  = DEFAULT;
    private var categoryId = 0 //类型
    /* 价格的图标，默认为第一种状态 */
    private var type = 0
    /*变量*/
    var filterCategory:List<GoodsData.FilterCategory>?=null
    var popupWindow:PopupWindow?=null




    override fun initView() {
        initText(mDataBinding.newgoodZonghe)//默认选中的文字为综合
        /*按钮选中监听*/
        mDataBinding.newgoodZonghe.setOnClickListener {
            initText(mDataBinding.newgoodZonghe)
            type = 0
            setIconType(type)
            categoryId = 1005001
            order = DESC
           /* if (popupWindow != null) {
                popupWindow.dismiss()
            } */
        }
        mDataBinding.newgoodPice.setOnClickListener {
            initText(mDataBinding.newgoodPice)
            if (type == 0) {
                type = 1
                setIconType(type)
                order = ASC
            } else if (type == 1) {
                type = 2
                setIconType(type)
                order = DESC
            } else {
                type = 1
                setIconType(type)
                order = ASC
            }
            initData()
           /* if (popupWindow != null) {
                popupWindow.dismiss()
            }*/
        }
        mDataBinding.newgoodKind.setOnClickListener {
            initText( mDataBinding.newgoodKind)
            type = 0
            setIconType(type)
            initData()
            //setPopw()
        }

    }
    //设置参数集合
    private fun initMap() : Map<String,String>{
       val map:HashMap<String,String> =HashMap()
       map.put("isNew",isNew.toString())
       map.put("page",page.toString())
       map.put("order",order)
       map.put("sort",sort)
       map.put("category",categoryId.toString())
       return map
    }

    //设置文字变红
    @SuppressLint("ResourceType")
    private fun initText(tv: TextView) {
        when(tv){
            mDataBinding.newgoodZonghe->{
                tv.setTextColor(Color.parseColor(getString(R.color.red)))
                mDataBinding.newgoodPice.setTextColor(Color.parseColor(getString(R.color.black)))
                mDataBinding.newgoodKind.setTextColor(Color.parseColor(getString(R.color.black)))
            }
            mDataBinding.newgoodPice->{
                tv.setTextColor(Color.parseColor(getString(R.color.red)))
                mDataBinding.newgoodZonghe.setTextColor(Color.parseColor(getString(R.color.black)))
                mDataBinding.newgoodKind.setTextColor(Color.parseColor(getString(R.color.black)))
            }
            else->{
                tv.setTextColor(Color.parseColor(getString(R.color.red)))
                mDataBinding.newgoodZonghe.setTextColor(Color.parseColor(getString(R.color.black)))
                mDataBinding.newgoodPice.setTextColor(Color.parseColor(getString(R.color.black)))
            }

        }
    }
    //设置价格的图标
    private fun setIconType(type: Int) {
        when (type) {
            0 -> Glide.with(this).load(R.mipmap.aa).into(mDataBinding!!.imgIcno)
            1 -> Glide.with(this).load(R.mipmap.up).into(mDataBinding!!.imgIcno)
            2 -> Glide.with(this).load(R.mipmap.dwon).into(mDataBinding!!.imgIcno)
        }
    }
    //数据请求
    override fun initVM() {
    mViewModel.getNewgoods(initMap())
    }
    //获得数据
    override fun initData() {
        mViewModel.data.observe(this, Observer {
            //获得数据列表
            initNewGoods(it.data)
            //分类数据
            filterCategory = it.filterCategory

        })
    }
    //获得数据
    private fun initNewGoods(data: List<GoodsData.DataX>) {
        mDataBinding!!.newgoodTitleImgRcy.layoutManager= GridLayoutManager(this,2)
        mDataBinding!!.newgoodTitleImgRcy.adapter= HomeNewGoodsTitleAdpter(this,data)
    }
    //设置弹出窗口
    private fun setPopw(){
        val inflate = View.inflate(this, R.layout.popw, null)
         popupWindow = PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, 300)
        //设置布局
        val pwrcy = inflate.findViewById<RecyclerView>(R.id.pw_rcy)
        pwrcy.layoutManager = GridLayoutManager(this, 5)
        //创建适配器
        pwrcy.adapter=HomeNewGoodsTitlePwAdpter(this,filterCategory!!)
        /*val categoryId = data.id
        val map:HashMap<String,String> =HashMap()
        map.put("isNew", 1.toString() + "")
        map.put("categoryId", categoryId.toString() + "")
        *//*mViewModel.getNewgoods(initMap())
        popupWindow.dismiss()*/


    }

    override fun initVariable() {
    }




}