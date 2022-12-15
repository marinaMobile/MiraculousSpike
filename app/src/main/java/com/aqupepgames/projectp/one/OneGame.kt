package com.aqupepgames.projectp.one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aqupepgames.projectp.R
import kotlin.random.Random

class OneGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_game)
    }

    companion object{
        var currentBalance = Random.nextInt(from = 3000, until = 10000)
    }
}