package com.aqupepgames.projectp.two

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aqupepgames.projectp.databinding.ActivityStartScreenBinding

class StartScreen : AppCompatActivity() {
    private lateinit var judyi : ActivityStartScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        judyi = ActivityStartScreenBinding.inflate(layoutInflater)
        setContentView(judyi.root)
        judyi.rijdasj.setOnClickListener {
            startActivity(Intent(this,ThreeGame::class.java))
        }
    }
}