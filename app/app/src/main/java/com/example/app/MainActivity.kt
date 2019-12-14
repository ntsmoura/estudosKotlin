package com.example.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.*

//const val EXTRA_MESSAGE = "com.example.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*button2.setOnClickListener{
         nomeApp.visibility = if(nomeApp.visibility==View.INVISIBLE)  View.VISIBLE
            else View.INVISIBLE
        }*/
        button.setOnClickListener{
            val msg = input.editText?.text.toString()
            if(msg.isNotBlank()) startActivity(Intent(this, Pagina2Activity::class.java).apply {
                    putExtra("int_value", msg)
                })
            else Toast.makeText(applicationContext,"Preencha o campo!",Toast.LENGTH_SHORT).show()
        }
    }

}
