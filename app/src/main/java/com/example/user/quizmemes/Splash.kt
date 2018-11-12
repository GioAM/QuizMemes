package com.example.user.quizmemes

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar

import kotlinx.android.synthetic.main.activity_splash.*

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var progresso =
                findViewById<ProgressBar>(
                        R.id.barraProgresso
                )

        Thread(Runnable {
            carregar(progresso)
        }).start()
    }

    fun carregar(barraProgresso : ProgressBar) {
        var progresso = 0

        while (progresso < 100) {
            try {
                Thread.sleep(1000)
                barraProgresso.setProgress(progresso)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            progresso += 10
        }

        val intent = Intent(
                this,
                MainActivity::class.java
        )
        startActivity(intent)
        finish()
    }

}