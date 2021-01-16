package com.example.shop

import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shop.mvvm.NewBindActivity
import com.example.shop.mytongpao.TongPaoActivity
import com.example.shop.mytongpao.TongPaoAdpter
import kotlinx.android.synthetic.main.activity_spalce2.*

class SpalceActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalce2)
        initView()
    }
    fun initView(){
        app.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        tongpao.setOnClickListener {
            startActivity(Intent(this,TongPaoActivity::class.java))
        }

    }
}