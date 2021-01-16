package com.example.shop.viewmodel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.shop.bean.home.BrandData
import com.example.shop.bean.home.HomeData
import com.shop.base.BaseViewHolder
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import kotlinx.coroutines.launch

class HomeBrandViewModel:BaseViewModel(Injection.repository) {
    //Brand的数据对象
    var brand:MutableLiveData<BrandData> = MutableLiveData()
    //网络请求的状态值  -1 网络请求错误
    var loadStatue: MutableLiveData<Int> = MutableLiveData()
    fun getBrand(page:String){
        viewModelScope.launch {
            val result = repository.getBrand(page)
            if(result!=null){
                brand.postValue(result.data)
            }else {
                loadStatue.postValue(-1)
            }
        }
    }
}