package com.example.shop.mytongpao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseArray
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shop.BR
import com.example.shop.R
import com.example.shop.SpalceActivity2
import com.example.shop.databinding.ActivityTongPaoBinding
import com.shop.base.BaseActivity

class TongPaoActivity:BaseActivity<TongPaoViewModel,ActivityTongPaoBinding>(R.layout.activity_tong_pao,TongPaoViewModel::class.java){
    var mAdapter : TongPaoAdpter?= null  //适配器
    var list: List<Stu> = listOf<Stu>()//创建集合
    //初始化布局
    override fun initView() {
        //设置rcy
        mDataBinding!!.tongpaoRlv.layoutManager=LinearLayoutManager(this)

    }


    //获得数据
    override fun initData() {
        mViewModel!!.getMore()
        //封装xml布局界面的id和数据对应绑定的id(适配器里用到的布局，跟xml文件layout之后的名字)
        var array=SparseArray<Int>()//存放布局的集合
        array.put(R.layout.tongpao1,BR.tongpao1)
        array.put(R.layout.tongpao2,BR.tongpao2)
        array.put(R.layout.tongpao3,BR.tongpao3)
        //创建适配器并绑定到rcy上
        mAdapter = TongPaoAdpter(this, list, array)
        mDataBinding!!.tongpaoRlv.adapter=mAdapter



    }

    override fun initVM() {
        mViewModel.stu.observe(this, Observer {
            mAdapter!!.refesh(it)
        })
    }

    override fun initVariable() {

    }
}