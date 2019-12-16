package com.example.easycalc

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    //Checa se último digito foi númerico
    var foiNumero = false
    //Checa validade da expressão
    var validade = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View){
        var textoBotao = (view as Button).text
        textoCentral.append(textoBotao)
        foiNumero = true
    }

    fun onClear(view: View){
        textoCentral.text = ""
        textSuperior.text = ""
        foiNumero = false
    }

    fun onOperator(view: View){
        var textoBotao = (view as Button).text
        validade = foiNumero
        textoCentral.append(textoBotao)
        foiNumero = false
    }

    fun onEquals(view: View){
        if(validade && foiNumero){
            var texto = textoCentral.text.toString()
            var express = ExpressionBuilder(texto).build()
            textSuperior.text = texto
            textoCentral.text = express.evaluate().toString()
        }
        else{
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle(R.string.alerta_title)
            builder.setMessage(R.string.alerta_conteúdo)
            builder.setPositiveButton(R.string.ok,null)
            var dialog = builder.create()
            dialog.show()
        }
    }
}
