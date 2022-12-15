package com.aqupepgames.projectp.two

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aqupepgames.projectp.databinding.ActivityWarninsScreenBinding

class WarninsScreen : AppCompatActivity() {
    private lateinit var hdysu : ActivityWarninsScreenBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hdysu = ActivityWarninsScreenBinding.inflate(layoutInflater)
        setContentView(hdysu.root)
        sharedPreferences = getSharedPreferences("win_res", Context.MODE_PRIVATE)
        val currentWin = sharedPreferences.getInt("win_res",0)
        hdysu.riijd.text = "Win : $currentWin"
        hdysu.bCnt.setOnClickListener {
            startActivity(Intent(this,ThreeGame::class.java))
        }
        hdysu.button2.setOnClickListener {
            startActivity(Intent(this,RecordsScreen::class.java))
        }
    }
}