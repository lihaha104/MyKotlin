package com.example.shop.viewmodel.shop

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.shop.bean.shop.ShopData
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import kotlinx.coroutines.launch

class ShopViewModel:BaseViewModel(Injection.repository){

    var shop: MutableLiveData<ShopData> = MutableLiveData()
    var loadStatue: MutableLiveData<Int> = MutableLiveData()

    fun getShop(){
        viewModelScope.launch {
         val shopList = repository.getShopList()
            if(shopList!=null){
                shop.postValue(shopList.data)
            }else{
                loadStatue.postValue(-1)
            }
        }
    }
}