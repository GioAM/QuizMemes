package com.example.user.quizmemes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Ranking : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)
        supportActionBar?.hide()
    }
}
