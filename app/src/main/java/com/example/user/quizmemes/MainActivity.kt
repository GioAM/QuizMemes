package com.example.user.quizmemes

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun jogar(view : View) {
        val intent = Intent(
                this,
                Jogo::class.java
        )
        startActivity(intent)
        finish()
    }
}
