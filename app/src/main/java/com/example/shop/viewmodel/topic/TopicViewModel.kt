package com.example.shop.viewmodel.topic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.shop.bean.home.TopicData
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import kotlinx.coroutines.launch

class TopicViewModel:BaseViewModel(Injection.repository) {
    //topic的数据对象
    var topic: MutableLiveData<TopicData> = MutableLiveData()
    //网络请求的状态
    //网络请求的状态值  -1 网络请求错误
    var loadStatue: MutableLiveData<Int> = MutableLiveData()
    fun getTopic(page:String){
        viewModelScope.launch {
            val result = repository.getTopic(page)
            if(result!=null){
                topic.postValue(result.data)
            }else{
                loadStatue.postValue(-1)
            }
        }

    }

}