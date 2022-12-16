package com.aqupepgames.projectp.four.acti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aqupepgames.projectp.R
import com.aqupepgames.projectp.databinding.ActivityRegBinding
import com.aqupepgames.projectp.four.inapps.ProductListing
import com.aqupepgames.projectp.one.OneGame
import com.aqupepgames.projectp.three.TwoGame
import com.aqupepgames.projectp.two.StartScreen
import com.aqupepgames.projectp.two.ThreeGame

class RegAct : AppCompatActivity() {
    lateinit var binding: ActivityRegBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.oneBtn.setOnClickListener{
            startActivity(Intent(this, OneGame::class.java))
        }

        binding.twoBtn.setOnClickListener {
            startActivity(Intent(this, TwoGame::class.java))
        }

        binding.threeBtn.setOnClickListener {
            startActivity(Intent(this, ThreeGame::class.java))
        }

        binding.shopBtn.setOnClickListener{
            startActivity(Intent(this, ProductListing::class.java))
        }
    }
}