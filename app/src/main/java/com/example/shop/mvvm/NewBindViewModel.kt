package com.example.shop.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shop.bean.home.HomeData

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL


class NewBindViewModel : ViewModel() {
    var title:String?="title"
    var status:MutableLiveData<Int> = MutableLiveData()

    fun homeData(){
        GlobalScope.launch {
            loadData()
        }
    }
    suspend fun loadData(){
        var homeData = get("https://cdplay.cn/api/index")
        if(homeData!=null){
           // title=homeData.data.topicList.get(0).title
            status.postValue(0)
            }
    }

    /*网络请求*/
    suspend fun get(url:String)= withContext(Dispatchers.IO){
        var result=URL(url).readText(charset("utf-8"))
        return@withContext Gson().fromJson<HomeData>(result,
            HomeData::class.java)
    }
}