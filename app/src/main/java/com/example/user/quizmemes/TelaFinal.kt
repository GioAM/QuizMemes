package com.example.user.quizmemes

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class TelaFinal : AppCompatActivity() {
    var resultado = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_final)
        supportActionBar?.hide()
        var telaFinal = getIntent()
        resultado = telaFinal.getStringExtra("resultado")
        findViewById<TextView>(R.id.result).setText(resultado)
    }

    fun novoJogo(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

    }

}


