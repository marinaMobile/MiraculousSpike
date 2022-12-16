package com.aqupepgames.projectp.four.acti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aqupepgames.projectp.AppClass
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

        val totalBalanceSP = getSharedPreferences("TOTAL_BAL_SP", MODE_PRIVATE)
        var tBalanceMain: Int? = totalBalanceSP.getInt(AppClass.TOTAL_BALANCE.toString(), 0)



        binding.totalBalanceMain.text = "Your balance is ${tBalanceMain.toString()}"

        binding.oneBtn.setOnClickListener{
            startActivity(Intent(this, OneGame::class.java))
            finish()
        }

        binding.twoBtn.setOnClickListener {
            startActivity(Intent(this, ThreeGame::class.java))
            finish()
        }

        binding.threeBtn.setOnClickListener {
            startActivity(Intent(this, TwoGame::class.java))
            finish()
        }

        binding.shopBtn.setOnClickListener{
            startActivity(Intent(this, ProductListing::class.java))
            finish()
        }
    }
}