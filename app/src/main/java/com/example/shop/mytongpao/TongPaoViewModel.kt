package com.example.shop.mytongpao

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import kotlinx.coroutines.launch

class TongPaoViewModel:BaseViewModel(Injection.repository) {
    var stu : MutableLiveData<List<Stu>> = MutableLiveData(listOf())


    fun getMore(){
        viewModelScope.launch {
            val more = repository.getMore()
            if(more!=null){
                stu.postValue(more.data.list)
            }
        }
    }

}