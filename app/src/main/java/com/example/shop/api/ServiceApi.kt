package com.example.shop.api

import com.example.shop.base.classes.BaseBean
import com.example.shop.bean.home.BrandData
import com.example.shop.bean.home.HomeData
import com.example.shop.mytongpao.TongPaoData

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ServiceApi {
    //同袍多布局（基础地址与小程序不同）
    @GET("discover/hot.json")
    suspend fun getMore():TongPaoData

    //刷新token
    @POST("auth/refreshToken")
    suspend fun refreshToken(): BaseBean<String>

    //首页数据
    @GET("index")
    suspend fun getHome(): BaseBean<HomeData>
    //品牌制造商直供
    @GET("brand/list")
    suspend fun getBrand(@Query("page")page:String):BaseBean<BrandData>





}