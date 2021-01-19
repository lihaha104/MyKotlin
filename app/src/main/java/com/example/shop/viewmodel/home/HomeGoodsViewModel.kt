package com.example.shop.viewmodel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.shop.bean.home.GoodsData
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import kotlinx.coroutines.launch

class HomeGoodsViewModel:BaseViewModel(Injection.repository) {
    //topic的数据对象
    var data: MutableLiveData<GoodsData> = MutableLiveData()
    //网络请求的状态值  -1 网络请求错误
    var loadStatue: MutableLiveData<Int> = MutableLiveData()

    fun getNewgoods(map: Map<String, String>){
        viewModelScope.launch {
            val result = repository.getNewgoods(map)
            if(result!=null){
                data.postValue(result.data)
            }else{
                loadStatue.postValue(-1)
            }
        }
    }


}