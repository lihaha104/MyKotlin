package com.example.shop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.shop.fragment.home.HomeFragment
import com.example.shop.fragment.me.MyFragment
import com.example.shop.fragment.shop.ShopFragment
import com.example.shop.fragment.sort.SortFragment
import com.example.shop.fragment.topic.TopicFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initVp()

    }

    fun initVp(){
        var names = arrayOf("首页","专题","分类","购物车","我的")
        //创建爱你集合
        val fragments = ArrayList<Fragment>()
        fragments.add(HomeFragment())
        fragments.add(TopicFragment())
        fragments.add(SortFragment())
        fragments.add(ShopFragment())
        fragments.add(MyFragment())
        //创建适配器并绑定
       main_vp!!.adapter=FragmentAdpter(supportFragmentManager,fragments)
        main_tab.setupWithViewPager(main_vp)
        //设置标题
        main_tab.getTabAt(0)?.setText(names[0])?.setIcon(R.drawable.selecthome)
        main_tab.getTabAt(1)?.setText(names[1])?.setIcon(R.drawable.selecttop)
        main_tab.getTabAt(2)?.setText(names[2])?.setIcon(R.drawable.selectsort)
        main_tab.getTabAt(3)?.setText(names[3])?.setIcon(R.drawable.selectshop)
        main_tab.getTabAt(4)?.setText(names[4])?.setIcon(R.drawable.selectme)


    }

    class FragmentAdpter(supportFragmentManager: FragmentManager, var fragments: ArrayList<Fragment>):
        FragmentStatePagerAdapter(supportFragmentManager) {
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return super.getPageTitle(position)
        }

    }






}


