package com.shop.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


/**
 * adapter基类
 * layouts 布局id与界面绑定name的id匹配使用
 * adapter通过DataBindingUtil实现界面和数据的绑定   ViewDataBinding
 */

open abstract class BaseMyAdapter<D>(val context: Context, var list:List<D>, val layout:Int):RecyclerView.Adapter<BaseMyAdapter<D>.BaseVH>() {

    /**
     * 用来初始化创建ViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVH {
        var dataBinding:ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),viewType,parent,false)

        return BaseVH(dataBinding)
    }

    /**
     * item的赋值  {绑定，动态赋值}
     */
    override fun onBindViewHolder(holder: BaseVH, position: Int) {
        //获取当前条目布局的ID
        var layoutId = getItemViewType(position)
        //获取layout id所对应的BR的id
        var type=layout
        holder.dataBinding.setVariable(type,list.get(position))
        holder.dataBinding.root.tag = position
        bindData(holder.dataBinding,list.get(position))

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return layoutId(position)
    }

    /**
     * 获取对应的布局
     */
    protected abstract fun layoutId(position: Int):Int

    protected abstract fun bindData(binding: ViewDataBinding,data:D)

    //内联函数  内部类
    inner class BaseVH(val dataBinding:ViewDataBinding) :RecyclerView.ViewHolder(dataBinding.root)
    //inner class BaseVH(view:View) :RecyclerView.ViewHolder(view)



}