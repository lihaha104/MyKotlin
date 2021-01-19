package com.example.shop.api

import com.example.shop.base.classes.BaseBean
import com.example.shop.bean.home.BrandData
import com.example.shop.bean.home.GoodsData
import com.example.shop.bean.home.HomeData
import com.example.shop.bean.home.TopicData

import com.example.shop.bean.sort.SortData
import com.example.shop.bean.sort.SortTabData
import com.example.shop.mytongpao.TongPaoData
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ServiceApi {
    //同袍多布局（基础地址与小程序不同）
    @GET("discover/hot.json")
    suspend fun getMore():TongPaoData
    //刷新token
    @POST("auth/refreshToken")
    suspend fun refreshToken(): BaseBean<String>
    /************首页***************/
    //首页数据
    @GET("index")
    suspend fun getHome(): BaseBean<HomeData>
    //品牌制造商直供
    @GET("brand/list")
    suspend fun getBrand(@Query("page")page:String):BaseBean<BrandData>
    //新品商品列表 ?isNew=1&page=1&size =1000&order=asc&sort=default&categoryId=0
    @GET("goods/list")
    suspend fun getNewgoods(@QueryMap map:Map<String,String>):BaseBean<GoodsData>





    /************专题***************/
    @GET("topic/list")
    suspend fun getTopic(@Query("page")page:String):BaseBean<TopicData>

    /************分类***************/
    @GET("catalog/index")//分类竖导航
    suspend fun getSortTab():BaseBean<SortTabData>
    @GET("catalog/current")//分类数据
    suspend fun getSort(@Query("id")id:Int):BaseBean<SortData>





}