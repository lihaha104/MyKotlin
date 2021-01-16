package com.example.shop.app

import android.app.Application
import com.example.shop.utils.MyMmkv

class MyApp: Application() {
    companion object{
        var instance:MyApp?=null
    }

    override fun onCreate() {
        super.onCreate()
        instance=this
        MyMmkv.initMmkv()

    }
}