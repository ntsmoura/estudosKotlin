package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pagina2.*

class Pagina2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina2)
        val message = intent.getStringExtra("int_value")
        val s = message.toInt()
        textpg2.text = (s+s).toString()
    }


}
