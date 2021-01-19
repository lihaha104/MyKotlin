package com.example.shop.viewmodel.sort

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.shop.bean.sort.SortData
import com.example.shop.bean.sort.SortTabData
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import kotlinx.coroutines.launch


class SortViewModel :BaseViewModel(Injection.repository){
    var sort: MutableLiveData<SortData> = MutableLiveData()
    var sorttab: MutableLiveData<SortTabData> = MutableLiveData()
    //网络请求的状态值  -1 网络请求错误
    var loadStatue: MutableLiveData<Int> = MutableLiveData()

    //获得tablayout的数据
     fun getSortTab(){
        viewModelScope.launch {
            val result = repository.getSortTab()
            if(result!=null){
                sorttab.postValue(result.data)
            }else {
                loadStatue.postValue(-1)
            }
        }

    }
    //获得列表数据
     fun getSort(id:Int){
        viewModelScope.launch {
            val result = repository.getSort(id)
            if(result!=null){
                sort.postValue(result.data)
            }else {
                loadStatue.postValue(-1)
            }
        }
    }
}


