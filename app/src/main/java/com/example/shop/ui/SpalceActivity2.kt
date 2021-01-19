package com.example.shop.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shop.R
import com.example.shop.homework.HomeWorkActivity
import com.example.shop.mytongpao.TongPaoActivity
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
        homework.setOnClickListener {
            startActivity(Intent(this,HomeWorkActivity::class.java))
        }
    }
}