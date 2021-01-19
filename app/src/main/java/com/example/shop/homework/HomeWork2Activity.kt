package com.example.shop.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.shop.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_home_work2.*

class HomeWork2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work2)
        inintab()
    }
     fun  inintab(){
       //tab
       tl_tab.addTab(tl_tab.newTab().setText("待成团"))
       tl_tab.addTab(tl_tab.newTab().setText("已成团"))
       tl_tab.addTab(tl_tab.newTab().setText("拼团失败"))

       tl_tab2.addTab(tl_tab2.newTab().setText("今日"))
       tl_tab2.addTab(tl_tab2.newTab().setText("7日"))
       tl_tab2.addTab(tl_tab2.newTab().setText("30日"))

       tl_tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
           override fun onTabReselected(p0: TabLayout.Tab?) {


           }

           override fun onTabUnselected(p0: TabLayout.Tab?) {

           }

           //
           override fun onTabSelected(tab: TabLayout.Tab?) {
               when (tab!!.position) {
                   0 -> {
                       view_ct_one.visibility= View.VISIBLE
                       view_ct_two.visibility= View.GONE
                       view_ct_three.visibility= View.GONE

                   }
                   1 -> {
                       view_ct_one.visibility= View.GONE
                       view_ct_two.visibility= View.VISIBLE
                       view_ct_three.visibility= View.GONE

                   }
                   2 ->{

                       view_ct_one.visibility= View.GONE
                       view_ct_two.visibility= View.GONE
                       view_ct_three.visibility= View.VISIBLE

                   }
               }
           }

       })

       tl_tab2.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
           override fun onTabReselected(p0: TabLayout.Tab?) {


           }

           override fun onTabUnselected(p0: TabLayout.Tab?) {

           }

           //
           override fun onTabSelected(tab: TabLayout.Tab?) {
               when (tab!!.position) {
                   0 -> {

                       view_sum_one.visibility= View.VISIBLE
                       view_sum_two.visibility= View.GONE
                       view_sum_three.visibility= View.GONE

                   }
                   1 -> {

                       view_sum_one.visibility= View.GONE
                       view_sum_two.visibility= View.VISIBLE
                       view_sum_three.visibility= View.GONE

                   }
                   2 ->{

                       view_sum_one.visibility= View.GONE
                       view_sum_two.visibility= View.GONE
                       view_sum_three.visibility= View.VISIBLE

                   }
               }
           }

       })
   }
}