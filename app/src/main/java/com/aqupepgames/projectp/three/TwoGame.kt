package com.aqupepgames.projectp.three

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import com.aqupepgames.projectp.R
import com.aqupepgames.projectp.databinding.ActivityTwoGameBinding
import com.aqupepgames.projectp.four.MainActivity
import com.aqupepgames.projectp.two.TwoUtils
import kotlin.random.Random

class TwoGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_game)
    }
}