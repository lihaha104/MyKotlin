package com.example.shop.mytongpao

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.example.shop.R
import com.shop.base.BaseMyAdapter
import com.shop.base.BaseTongPaoAdapter

class TongPaoAdpter(context: Context, list: List<Stu>, layouts: SparseArray<Int>) :
    BaseTongPaoAdapter<Stu>(context, list, layouts){
    //获得布局
    override fun layoutId(position: Int): Int {
        val filePathList = list.get(position).filePathList//获得每条数据的照片

            val size = filePathList.size//获得有几张图片
            if (size == 3) {
                return R.layout.tongpao3
            } else if (size == 1) {
                return R.layout.tongpao2
            }

        return R.layout.tongpao1


    }

    //绑定数据
    override fun bindData(binding: ViewDataBinding, data: Stu) {
        val filePathList = data.filePathList
        for (i in filePathList.indices) {
            val size = filePathList.size//获得有几张图片
            if (size == 3) {
                Glide.with(context).load(filePathList.first().filePath)
                    .into(binding.root.findViewById(R.id.img11))
                Glide.with(context).load(filePathList.get(1).filePath)
                    .into(binding.root.findViewById(R.id.img22))
                Glide.with(context).load(filePathList.last().filePath)
                    .into(binding.root.findViewById(R.id.img33))
            } else if (size == 1) {
                Glide.with(context).load(filePathList.get(0).filePath)
                    .into(binding.root.findViewById(R.id.img12))

            }
        }
    }

    fun refesh(lt: List<Stu>) {
        list=lt
        notifyDataSetChanged()
    }
}