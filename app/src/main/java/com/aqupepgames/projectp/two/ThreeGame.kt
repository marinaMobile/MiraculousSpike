package com.aqupepgames.projectp.two

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.Toast
import com.aqupepgames.projectp.AppClass.Companion.TOTAL_BALANCE
import com.aqupepgames.projectp.databinding.ActivityThreeGameBinding
import com.aqupepgames.projectp.databinding.ActivityTwoGameBinding
import com.aqupepgames.projectp.four.MainActivity
import com.aqupepgames.projectp.four.acti.RegAct
import kotlin.random.Random

class ThreeGame : AppCompatActivity() {
    private lateinit var b_sec : ActivityThreeGameBinding
    private var isClicked = false
    private lateinit var sharedPreference : SharedPreferences
    private lateinit var totalSharedPref : SharedPreferences
    private var pqwoeqfw: CountDownTimer? = null
    private var winRes = 0
    var totalBalance: Int? = 0
    var warningsscr = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b_sec = ActivityThreeGameBinding.inflate(layoutInflater)
        setContentView(b_sec.root)
        totalSharedPref = getSharedPreferences("TOTAL_BAL_SP", MODE_PRIVATE)
        totalBalance = totalSharedPref.getInt(TOTAL_BALANCE.toString(), 0)
        b_sec.tvSecBalance.text = totalBalance.toString()
        sharedPreference = getSharedPreferences("win_res", Context.MODE_PRIVATE)
        val def_txt_win = sharedPreference.getInt("win_res",winRes)
        b_sec.tvSecWin.text = "Your win : $def_txt_win"
        if(isClicked== false){
            b_sec.tvSecBSpn.setOnClickListener {
                if(totalBalance!=0){
                    asdasdasdhasdihdsah()
                } else {
                    Toast.makeText(this, "Your balance is 0", Toast.LENGTH_SHORT).show()
                }


            }
        }
        b_sec.logOut.setOnClickListener {
            startActivity(Intent(this, StartScreen::class.java))
        }
    }

    private fun asdasdasdhasdihdsah() = with(b_sec){
        var clasodoksakoasdokasd = 0
        pqwoeqfw?.cancel()
        pqwoeqfw = object : CountDownTimer(4000,100){
            override fun onTick(millisUntilFinished: Long) {
                clasodoksakoasdokasd++
                isClicked = true
                tvSecBSpn.alpha = 0.7f
                if(clasodoksakoasdokasd>5) clasodoksakoasdokasd = 0
                img1SecGm.setImageResource(TwoUtils.imgLis[clasodoksakoasdokasd])
                Handler().postDelayed({
                    img2SecGm.setImageResource(TwoUtils.imgLis[clasodoksakoasdokasd])
                },300)
                Handler().postDelayed({
                    img3SecGm.setImageResource(TwoUtils.imgLis[clasodoksakoasdokasd])
                },600)

            }

            override fun onFinish() {
                isClicked = false
                tvSecBSpn.alpha = 1.0f
                warningsscr-=1
                pwqwqeqew()

            }

        }.start()
    }

    private fun pwqwqeqew() =with(b_sec) {
        val bonus_res = TwoUtils.listBonus[Random.nextInt(18)]
        val img_1 = TwoUtils.imgLis[Random.nextInt(6)]
        val img_2 = TwoUtils.imgLis[Random.nextInt(6)]
        val img_3 = TwoUtils.imgLis[Random.nextInt(6)]
        if(img_1 == 3 || img_2 == 5 || img_3 == 6){
            totalBalance = totalBalance?.minus(100)
            totalSharedPref.edit().putInt(TOTAL_BALANCE.toString(), totalBalance!!).apply()
            tvSecBalance.text = totalBalance.toString()
        }
        if(img_1 == 2 || img_2 ==3 || img_3 == 4){
            totalBalance = totalBalance?.plus(10)
            totalSharedPref.edit().putInt(TOTAL_BALANCE.toString(), totalBalance!!).apply()
            tvSecBalance.text = totalBalance.toString()
        }
        if(img_1 == 1 && img_2 == 1 && img_3 ==1) {
            totalBalance = totalBalance?.plus(20)
            totalSharedPref.edit().putInt(TOTAL_BALANCE.toString(), totalBalance!!).apply()
            tvSecBalance.text = totalBalance.toString()
        }

        if (img_1 ==3 && img_2 ==3 && img_3 == 3){
            totalBalance = totalBalance?.minus(300)
            totalSharedPref.edit().putInt(TOTAL_BALANCE.toString(), totalBalance!!).apply()
            tvSecBalance.text = totalBalance.toString()
        }
        if(img_1 == 2 && img_2 == 1 || img_3 == 4 && img_1 == 5){
            totalBalance = totalBalance?.minus(250)
            totalSharedPref.edit().putInt(TOTAL_BALANCE.toString(), totalBalance!!).apply()
            tvSecBalance.text = totalBalance.toString()
        }

        if(img_1 == 3 && img_2 == 4 || img_3 == 6 && img_1 == 5){
            totalBalance = totalBalance?.plus(30)
            totalSharedPref.edit().putInt(TOTAL_BALANCE.toString(), totalBalance!!).apply()
            tvSecBalance.text = totalBalance.toString()
        }
        val totalWin = totalBalance?.times(bonus_res)
        val parse_total = totalWin?.toInt()
        totalWin?.toInt()?.let { sharedPreference.edit().putInt("win_res", it).apply() }
        tvSecWin.text = "Your win : $parse_total"
        img1SecGm.setImageResource(img_1)
        img2SecGm.setImageResource(img_2)
        img3SecGm.setImageResource(img_3)
        tvSecBonus.text = "Bonus : x$bonus_res"

        if(warningsscr == 0){
            startActivity(Intent(this@ThreeGame,WarninsScreen::class.java))
        }



    }

    override fun onBackPressed() {
        super.onBackPressed()

        val finalBalanceString = b_sec.tvSecBalance.text.toString()
        val finalBalance = finalBalanceString.toInt()
        val totalBalanceSP = getSharedPreferences("TOTAL_BAL_SP", MODE_PRIVATE)
        totalBalanceSP.edit().putInt(TOTAL_BALANCE.toString(), finalBalance).apply()

        startActivity(Intent(this, RegAct::class.java))
        finish()

    }

    override fun onDestroy() {
        super.onDestroy()
        val finalBalanceString = b_sec.tvSecBalance.text.toString()
        val finalBalance = finalBalanceString.toInt()
        val totalBalanceSP = getSharedPreferences("TOTAL_BAL_SP", MODE_PRIVATE)
        totalBalanceSP.edit().putInt(TOTAL_BALANCE.toString(), finalBalance).apply()
    }

    override fun onStop() {
        super.onStop()
        val finalBalanceString = b_sec.tvSecBalance.text.toString()
        val finalBalance = finalBalanceString.toInt()
        val totalBalanceSP = getSharedPreferences("TOTAL_BAL_SP", MODE_PRIVATE)
        totalBalanceSP.edit().putInt(TOTAL_BALANCE.toString(), finalBalance).apply()
    }

}