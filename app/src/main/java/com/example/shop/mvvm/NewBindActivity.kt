package com.example.shop.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shop.BR
import com.example.shop.R
import com.example.shop.databinding.ActivityNewBindBinding

class NewBindActivity : AppCompatActivity() {
    var mBing:ActivityNewBindBinding?=null
    var vm:NewBindViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBing=DataBindingUtil.setContentView(this,R.layout.activity_new_bind)
        initVM()
    }
    fun initVM(){
        vm=ViewModelProvider(this).get(NewBindViewModel::class.java)
        vm!!.homeData()
        vm!!.status.observe(this, Observer {
            if(it==0){
               mBing!!. setVariable(BR.title,vm)
            }
        })

    }
}