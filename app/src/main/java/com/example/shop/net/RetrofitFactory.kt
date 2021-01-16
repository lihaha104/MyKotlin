package com.example.shop.net

import com.example.shop.app.Constants
import com.example.shop.app.MyApp
import com.example.shop.utils.MyMmkv
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/*
* 网络请求
* */

class RetrofitFactory{
    /*
    * 伴生对象   单例
    * */
    companion object{
        val instance:RetrofitFactory by lazy { RetrofitFactory() }
    }

    private val HeaderInterceptor:Interceptor//头拦截器
    private val retrofit: Retrofit   //retrofit

    init {
        //通用拦截
        HeaderInterceptor=Interceptor {
            chain ->  val request=chain.request()
            .newBuilder()
            .addHeader("charset","UTF-8")
            .addHeader("token",MyMmkv.getString(Constants.token))
            .build()

            chain.proceed(request)
        }

        //retrofit实例化
        retrofit=Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(initClient())
            .build()
    }

   private fun initClient():OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(LoggingInterceptor())//添加拦截器
          //.addInterceptor(interceptor)
            .connectTimeout(6, TimeUnit.SECONDS)
            .readTimeout(6, TimeUnit.SECONDS)
            .build()
    }

    /*
    * 日志拦截器
    * */
    class LoggingInterceptor:Interceptor{
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            val proceed = chain.proceed(request)
            proceed.peekBody(Long.MAX_VALUE)
            return proceed

        }
    }

    /*
    * 服务实例化
    * */
    fun <T> create(service:Class<T>):T{
        return retrofit.create(service)
    }


}