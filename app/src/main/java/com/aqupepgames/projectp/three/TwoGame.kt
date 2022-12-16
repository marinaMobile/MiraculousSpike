package com.aqupepgames.projectp.three

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aqupepgames.projectp.AppClass.Companion.TOTAL_BALANCE
import com.aqupepgames.projectp.databinding.ActivityTwoGameBinding
import com.aqupepgames.projectp.four.acti.RegAct
import com.aqupepgames.projectp.one.OneGame

class TwoGame : AppCompatActivity() {

    private lateinit var bindMachineGame: ActivityTwoGameBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindMachineGame = ActivityTwoGameBinding.inflate(layoutInflater)
        setContentView(bindMachineGame.root)

        val wheel = bindMachineGame.wheeeel

        //inital set
        var scoreInt = 10
        bindMachineGame.scoreText.text = scoreInt.toString()
        val totalBalanceSP: SharedPreferences = getSharedPreferences("TOTAL_BAL_SP", MODE_PRIVATE)
        var totalBalance: Int? = totalBalanceSP.getInt(TOTAL_BALANCE.toString(), 0)

        bindMachineGame.totalBalanceTxtView.text = totalBalance.toString()

        //plus/minus setter
        bindMachineGame.plusBtn.setOnClickListener {
            scoreInt += 10
            bindMachineGame.scoreText.text = scoreInt.toString()
            if (scoreInt >0){
                bindMachineGame.minusBtn.isClickable = true
                bindMachineGame.scoreText.textSize = 36F
            }
            val balanceCurrent = bindMachineGame.totalBalanceTxtView.text.toString()
            val balanceCurrentInt = balanceCurrent.toInt()

            if (scoreInt==balanceCurrentInt){
                bindMachineGame.plusBtn.isClickable = false
            }


        }

        bindMachineGame.minusBtn.setOnClickListener {
            scoreInt -= 10
            bindMachineGame.scoreText.text = scoreInt.toString()

            if (scoreInt == 0){
                bindMachineGame.scoreText.text = "Can't go lower than 10"
                bindMachineGame.scoreText.textSize = 24F
                bindMachineGame.minusBtn.isClickable = false
            }

            val balanceCurrent = bindMachineGame.totalBalanceTxtView.text.toString()
            val balanceCurrentInt = balanceCurrent.toInt()
            if (scoreInt<balanceCurrentInt){
                bindMachineGame.plusBtn.isClickable = true
            }
            //failsafe from going negative

        }


        bindMachineGame.blackBtn.setOnClickListener{
            wheel.animate().apply {
                rotation(wheel.rotation + 180F)
                duration = 2000
                start()
            }

            if(totalBalance!=0) {
                totalBalance = totalBalance?.minus(scoreInt)
                bindMachineGame.totalBalanceTxtView.text = totalBalance.toString()


                val rnds = (1..2).random()

                if (rnds == 1){
                    totalBalance = totalBalance?.plus(scoreInt*2)
                    bindMachineGame.totalBalanceTxtView.text = totalBalance.toString()
                    bindMachineGame.gameStatusTextView.text = "Black! You have won!"
                } else
                {
                    bindMachineGame.gameStatusTextView.text = "Red! Better luck next time!"

                }
            } else {
                Toast.makeText(this, "Your balance is 0", Toast.LENGTH_SHORT).show()

            }
        }


        bindMachineGame.redBtn.setOnClickListener{
            wheel.animate().apply {
                rotation(wheel.rotation + 180F)
                duration = 2000
                start()
            }

            if(totalBalance!=0) {
                totalBalance = totalBalance?.minus(scoreInt)
                bindMachineGame.totalBalanceTxtView.text = totalBalance.toString()
                val rnds = (1..2).random()

                if (rnds == 1){
                    totalBalance = totalBalance?.plus(scoreInt*2)
                    bindMachineGame.totalBalanceTxtView.text = totalBalance.toString()
                    bindMachineGame.gameStatusTextView.text = "Red! You have won!"
                } else {
                    bindMachineGame.gameStatusTextView.text = "Black! Better luck next time!"

                }

            } else {
                Toast.makeText(this, "Your balance is 0", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()

        val finalBalanceString = bindMachineGame.totalBalanceTxtView.text.toString()
        val finalBalance = finalBalanceString.toInt()
        val totalBalanceSP = getSharedPreferences("TOTAL_BAL_SP", MODE_PRIVATE)
        totalBalanceSP.edit().putInt(TOTAL_BALANCE.toString(), finalBalance).apply()

        startActivity(Intent(this, RegAct::class.java))
        finish()

    }

    override fun onDestroy() {
        super.onDestroy()
        val finalBalanceString = bindMachineGame.totalBalanceTxtView.text.toString()
        val finalBalance = finalBalanceString.toInt()
        val totalBalanceSP = getSharedPreferences("TOTAL_BAL_SP", MODE_PRIVATE)
        totalBalanceSP.edit().putInt(TOTAL_BALANCE.toString(), finalBalance).apply()
    }

    override fun onStop() {
        super.onStop()
        val finalBalanceString = bindMachineGame.totalBalanceTxtView.text.toString()
        val finalBalance = finalBalanceString.toInt()
        val totalBalanceSP = getSharedPreferences("TOTAL_BAL_SP", MODE_PRIVATE)
        totalBalanceSP.edit().putInt(TOTAL_BALANCE.toString(), finalBalance).apply()
    }


}