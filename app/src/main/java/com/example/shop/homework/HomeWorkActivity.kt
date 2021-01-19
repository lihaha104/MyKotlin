package com.example.shop.homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shop.R
import kotlinx.android.synthetic.main.activity_home_work.*
import kotlinx.android.synthetic.main.activity_spalce2.*

class HomeWorkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work)
        initView()
    }
    fun initView(){
        ok.setOnClickListener {
            startActivity(Intent(this,HomeWork2Activity::class.java))
        }
    }
}