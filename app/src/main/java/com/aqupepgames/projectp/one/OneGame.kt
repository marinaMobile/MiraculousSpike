package com.aqupepgames.projectp.one

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aqupepgames.projectp.R
import com.aqupepgames.projectp.four.acti.RegAct
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class OneGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_game)
    }

    override fun onBackPressed() {
        val fragmentInstance =
            supportFragmentManager.findFragmentById(R.id.frag_hold)?.childFragmentManager?.fragments?.last()
        if (fragmentInstance is MainLooadFragment || fragmentInstance is InitFragment) {
            val intent = Intent(this, RegAct::class.java)
            startActivity(intent)
            finish()
        } else{
            super.onBackPressed()
        }
    }
}