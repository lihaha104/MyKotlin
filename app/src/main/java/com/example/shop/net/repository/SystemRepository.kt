package com.example.shop.net.repository

import com.example.shop.api.ServiceApi
import com.example.shop.mytongpao.TongPaoData
import com.example.shop.net.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/*
* 数据仓库
* 用来连接ViewModel和Model
* 定义业务相关的网络请求接口
* */
class SystemRepository {

    private lateinit var serviceApi:ServiceApi
    //初始化方法
    init{
        serviceApi=RetrofitFactory.instance.create(ServiceApi::class.java)
    }
    /*
   * 同袍数据
   * */
    suspend fun getMore():TongPaoData= withContext(Dispatchers.IO){
        serviceApi.getMore()
    }
    /**
     * 刷新token
     */
    suspend fun refreshToken() = withContext(Dispatchers.IO){
        serviceApi.refreshToken()
    }
    /*
    * 获得主页的数据
    * */
    suspend fun getHome()= withContext(Dispatchers.IO){
        serviceApi.getHome()
    }
    //Brand
    suspend fun getBrand(page:String)= withContext(Dispatchers.IO){
        serviceApi.getBrand(page)
    }
    //Goods
    suspend fun getNewgoods(map:Map<String,String>)= withContext(Dispatchers.IO){
        serviceApi.getNewgoods(map)
    }

    /*
    * 获得Topic
    * */
    suspend fun getTopic(page: String)= withContext(Dispatchers.IO){
        serviceApi.getTopic(page)
    }

    /*
    * 获得分类
    * */
    //分类tab
    suspend fun getSortTab()= withContext(Dispatchers.IO){
        serviceApi.getSortTab()
    }
    //分类数据
    suspend fun getSort(id: Int)= withContext(Dispatchers.IO){
        serviceApi.getSort(id)
    }


}