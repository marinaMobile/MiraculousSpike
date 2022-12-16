package com.aqupepgames.projectp.three

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aqupepgames.projectp.AppClass.Companion.TOTAL_BALANCE
import com.aqupepgames.projectp.databinding.ActivityTwoGameBinding

class TwoGame : AppCompatActivity() {

    private lateinit var bindMachineGame: ActivityTwoGameBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindMachineGame = ActivityTwoGameBinding.inflate(layoutInflater)
        setContentView(bindMachineGame.root)

        //inital set
        var scoreInt = 10
        bindMachineGame.scoreText.text = scoreInt.toString()
        val totalBalanceSP = getSharedPreferences("TOTAL_BAL_SP", MODE_PRIVATE)
        var totalBalance: Int? = totalBalanceSP.getInt(TOTAL_BALANCE.toString(), 0)
        bindMachineGame.totalBalanceTxtView.text = totalBalance.toString()

        //plus/minus setter
        bindMachineGame.plusBtn.setOnClickListener {
            scoreInt += 10
            bindMachineGame.scoreText.text = scoreInt.toString()
        }

        bindMachineGame.minusBtn.setOnClickListener {
            scoreInt -= 10
            bindMachineGame.scoreText.text = scoreInt.toString()


            //failsafe from going negative
            if (scoreInt == 0){
                bindMachineGame.scoreText.text = "Can't go lower than 0"
                bindMachineGame.minusBtn.isClickable = false
            }
        }


        bindMachineGame.blackBtn.setOnClickListener{
            if(totalBalance!=0) {
                totalBalance = totalBalance?.minus(scoreInt)
                bindMachineGame.totalBalanceTxtView.text = totalBalance.toString()
                bindMachineGame.wheeeel.rotation = 180F

                val rnds = (1..2).random()

                if (rnds == 1){
                    totalBalance = totalBalance?.plus(scoreInt*2)
                    bindMachineGame.totalBalanceTxtView.text = totalBalance.toString()
                    Toast.makeText(this, "Black! You have won!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Your balance is 0", Toast.LENGTH_SHORT).show()
            }
        }


        bindMachineGame.redBtn.setOnClickListener{
            if(totalBalance!=0) {
                totalBalance = totalBalance?.minus(scoreInt)
                bindMachineGame.totalBalanceTxtView.text = totalBalance.toString()

                bindMachineGame.wheeeel.rotation = 180F
                val rnds = (1..2).random()

                if (rnds == 1){
                    totalBalance = totalBalance?.plus(scoreInt*2)
                    bindMachineGame.totalBalanceTxtView.text = totalBalance.toString()
                    Toast.makeText(this, "Red! You have won!", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Your balance is 0", Toast.LENGTH_SHORT).show()
            }
        }


    }
}