package com.example.user.quizmemes

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Size
import android.view.Gravity
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class Ranking : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)
        supportActionBar?.hide()
    }
    fun retornar(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    override fun onResume() {
        super.onResume()
        var banco = openOrCreateDatabase("QuizMemes", Context.MODE_PRIVATE, null)

        var pontuacao = findViewById<TableLayout>(R.id.tabela)

        pontuacao.removeAllViews()

        var linhas = banco.rawQuery("""
            SELECT nome, pontuacao
            FROM jogo ORDER BY pontuacao DESC
        """, null)

        while (linhas.moveToNext()) {
            var linha = TableRow(this)

            val nome = TextView(this)
            val pontos = TextView(this)

            nome.gravity = Gravity.CENTER
            pontos.gravity = Gravity.CENTER

            nome.textSize = 20.0.toFloat()
            pontos.textSize = 20.0.toFloat()

            nome.text = linhas.getString(0)
            pontos.text = linhas.getString(1)

            linha.addView(nome)
            linha.addView(pontos)

            pontuacao.addView(linha)
        }
        banco.close()
    }
}
