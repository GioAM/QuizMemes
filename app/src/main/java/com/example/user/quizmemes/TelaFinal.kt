package com.example.user.quizmemes

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import pl.droidsonroids.gif.GifImageView

class TelaFinal : AppCompatActivity() {
    var resultado = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_final)
        supportActionBar?.hide()
        var telaFinal = getIntent()
        resultado = telaFinal.getStringExtra("resultado")
        if(resultado == "ganhou"){
            findViewById<GifImageView>(R.id.gif).setImageResource(resources.getIdentifier("win","mipmap",packageName))
            findViewById<TextView>(R.id.result).setText("Você atingiu a meta, agora vamos dobrar a meta!")
        }else if(resultado == "perdeu"){
            findViewById<GifImageView>(R.id.gif).setImageResource(resources.getIdentifier("sad","mipmap",packageName))
            findViewById<TextView>(R.id.result).setText("'Não acho que quem ganhar ou quem perder, nem quem ganhar nem perder, vai ganhar ou perder. Vai todo mundo perder.'")
        }
    }

    fun novoJogo(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}


