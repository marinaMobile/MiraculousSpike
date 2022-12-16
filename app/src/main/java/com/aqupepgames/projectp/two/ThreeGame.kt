package com.aqupepgames.projectp.two

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import com.aqupepgames.projectp.databinding.ActivityThreeGameBinding
import com.aqupepgames.projectp.databinding.ActivityTwoGameBinding
import com.aqupepgames.projectp.four.MainActivity
import com.aqupepgames.projectp.four.acti.RegAct
import kotlin.random.Random

class ThreeGame : AppCompatActivity() {
    private lateinit var b_sec : ActivityThreeGameBinding
    private var isClicked = false
    private lateinit var sharedPreference : SharedPreferences
    private var pqwoeqfw: CountDownTimer? = null
    private var winRes = 0
    var warningsscr = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b_sec = ActivityThreeGameBinding.inflate(layoutInflater)
        setContentView(b_sec.root)
        sharedPreference = getSharedPreferences("win_res", Context.MODE_PRIVATE)
        val def_txt_win = sharedPreference.getInt("win_res",winRes)
        b_sec.tvSecWin.text = "Your win : $def_txt_win"
        if(isClicked== false){
            b_sec.tvSecBSpn.setOnClickListener {
                asdasdasdhasdihdsah()

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
        val extra_chance = TwoUtils.listExtra[Random.nextInt(18)]
        val img_1 = TwoUtils.imgLis[Random.nextInt(6)]
        val img_2 = TwoUtils.imgLis[Random.nextInt(6)]
        val img_3 = TwoUtils.imgLis[Random.nextInt(6)]
        val getOldWin = sharedPreference.getInt("win_res",0)
        val totalWin = getOldWin + extra_chance * bonus_res * 100
        val parse_total = totalWin.toInt()
        sharedPreference.edit().putInt("win_res",totalWin.toInt()).apply()
        tvSecWin.text = "Your win : $parse_total"
        img1SecGm.setImageResource(img_1)
        img2SecGm.setImageResource(img_2)
        img3SecGm.setImageResource(img_3)
        tvSecBonus.text = "Bonus : x$bonus_res"
        tvSecBalance.text = "Extra chance : x$extra_chance"

        if(warningsscr == 0){
            startActivity(Intent(this@ThreeGame,WarninsScreen::class.java))
        }



    }
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, RegAct::class.java))
        finish()
    }
}