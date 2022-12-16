package com.aqupepgames.projectp.one

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aqupepgames.projectp.R
import com.aqupepgames.projectp.four.acti.RegAct
import kotlin.random.Random

class OneGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_game)
    }

    companion object{
        var currentBalance = Random.nextInt(from = 3000, until = 10000)
    }


    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, RegAct::class.java))
        finish()
    }
}