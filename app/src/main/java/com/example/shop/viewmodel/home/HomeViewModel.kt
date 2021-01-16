package com.example.shop.viewmodel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.shop.bean.home.HomeData
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel(Injection.repository) {
    //首页的数据对象
    var home: MutableLiveData<HomeData> = MutableLiveData()

    //网络请求的状态值  -1 网络请求错误
    var loadStatue: MutableLiveData<Int> = MutableLiveData()
    fun gethome() {
        viewModelScope.launch {
            var result = repository.getHome()
            if (result != null) {
                home.postValue(result.data)
            } else {
                loadStatue.postValue(-1)
            }
        }
    }
}