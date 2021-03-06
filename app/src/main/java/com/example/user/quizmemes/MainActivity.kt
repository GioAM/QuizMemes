package com.example.user.quizmemes

import android.content.Context
import android.content.Intent
import android.media.session.MediaController
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        var banco = openOrCreateDatabase("QuizMemes", Context.MODE_PRIVATE, null)
        banco.execSQL(
                """CREATE TABLE IF NOT EXISTS jogo
                 (
                    id  INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome VARCHAR(254),
                    pontuacao INTEGER
                 );"""
        )
        banco.close()
    }
    fun jogar(view : View) {
        val pagInicial = Intent(this, Jogo::class.java)
        pagInicial.putExtra("nome",findViewById<EditText>(R.id.nome).text.toString())
        startActivity(pagInicial)
        finish()
    }
    fun info(view : View) {
        val intent = Intent(this, Informacao::class.java)
        startActivity(intent)
    }
    fun ranking(view : View) {
        val intent = Intent(this, Ranking::class.java)
        startActivity(intent)
        finish()
    }
}
