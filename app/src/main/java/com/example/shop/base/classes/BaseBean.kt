package com.example.shop.base.classes
/*
*  // BaseResp抽取的一个bean类的外层结构 homeData当前接口返回的具体
*
* */

data class BaseBean<T>
    constructor(
    var data: T,
    var errmsg: String,
    var errno: Int
)
