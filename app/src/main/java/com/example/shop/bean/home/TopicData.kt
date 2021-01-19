package com.example.shop.bean.home

data class TopicData(
    val count: Int,
    val currentPage: Int,
    val `data`: List<DataX>,
    val pageSize: Int,
    val totalPages: Int
)

{

    data class DataX(
        val id: Int,
        val price_info: String,
        val scene_pic_url: String,
        val subtitle: String,
        val title: String
    )
}
