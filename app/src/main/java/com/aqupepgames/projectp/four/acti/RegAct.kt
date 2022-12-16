package com.aqupepgames.projectp.four.acti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.aqupepgames.projectp.AppClass
import com.aqupepgames.projectp.AppClass.Companion.USER_NAME
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

//        val user = getSharedPreferences("UserName", MODE_PRIVATE)
//        val userName = user.getString("userName", "null")
//        val namename = binding.nameText

        val goodBtn = binding.goodBtn
        goodBtn.setOnClickListener {
           if(binding.nameText.text.toString() != ""){
               binding.nameText.keyListener = null
           } else {
               Toast.makeText(this, "Please input your name, player!", Toast.LENGTH_SHORT).show()
           }
        }


//        var nameStr = namename.text.toString()
//
//        if(userName != "null") {
//            nameStr = userName.toString()
//            goodBtn.isClickable = false
//        }

//        goodBtn.setOnClickListener {
//            if(TextUtils.isEmpty(nameStr)|| nameStr == "null") {
//                namename.error = "This field is empty or null"
//                binding.oneBtn.isClickable = false
//                binding.twoBtn.isClickable = false
//                binding.threeBtn.isClickable = false
//                binding.shopBtn.isClickable = false
//            } else if (!TextUtils.isEmpty(nameStr)) {
//                binding.oneBtn.isClickable = true
//                binding.twoBtn.isClickable = true
//                binding.threeBtn.isClickable = true
//                binding.shopBtn.isClickable = true
//
//                user.edit().putString("userName", nameStr).apply()
//
//            }
//        }


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