package com.aqupepgames.projectp.three

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.GestureDetector
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat
import com.aqupepgames.projectp.R
import com.aqupepgames.projectp.databinding.ActivityTwoGameBinding
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class TwoGame : AppCompatActivity() {

    private lateinit var bindMachineGame: ActivityTwoGameBinding

    private var r = java.util.Random()
    private var ufherhfoerhf1: Int = 0
    private var ufherhfoerhf2: Int = 0
    private var ufherhfoerhf3: Int = 0
    private var starterScore = 10000
    private lateinit var kjebgoeg: ImageView
    private lateinit var ferhjg: ImageView
    private lateinit var bhtyhj57k: ImageView
    private lateinit var gb46j: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindMachineGame = ActivityTwoGameBinding.inflate(layoutInflater)
        setContentView(bindMachineGame.root)
        bindMachineGame.imvOne.also { kjebgoeg = it }
        bindMachineGame.imvTwo.also { ferhjg = it }
        bindMachineGame.imvThree.also { bhtyhj57k = it }
        bindMachineGame.scoreText.also { gb46j = it }
        gb46j.text = starterScore.toString()

        bindMachineGame.rollBtn.setOnClickListener{
            val minus1k: Int = starterScore-1000
            starterScore = minus1k
            gb46j.text = starterScore.toString()

            kjebgoeg.setBackgroundResource(R.drawable.anime)
            val imageOneAnim: AnimationDrawable = kjebgoeg.background as AnimationDrawable
            imageOneAnim.start()

            ferhjg.setBackgroundResource(R.drawable.anime)
            val imageTwoAnim: AnimationDrawable = ferhjg.background as AnimationDrawable
            imageTwoAnim.start()

            bhtyhj57k.setBackgroundResource(R.drawable.anime)
            val imageThrAnim: AnimationDrawable = bhtyhj57k.background as AnimationDrawable
            imageThrAnim.start()

            Handler(Looper.getMainLooper()).postDelayed({
                imageOneAnim.stop()
                imageTwoAnim.stop()
                imageThrAnim.stop()

                febgrhtg4uj67ik()

                fcvry5yji7o()

            }, 1000)
        }

    }

    private fun febgrhtg4uj67ik() {
        ufherhfoerhf1 = r.nextInt(5)+1
        ufherhfoerhf2 = r.nextInt(5)+1
        ufherhfoerhf3 = r.nextInt(5)+1

        when (ufherhfoerhf1) {
            1 ->
                kjebgoeg.setBackgroundResource(R.drawable.one)
            2 ->
                kjebgoeg.setBackgroundResource(R.drawable.two)
            3 ->
                kjebgoeg.setBackgroundResource(R.drawable.three)
            4 ->
                kjebgoeg.setBackgroundResource(R.drawable.four)
            5 ->
                kjebgoeg.setBackgroundResource(R.drawable.five)
        }
        when (ufherhfoerhf2) {
            1 ->
                ferhjg.setBackgroundResource(R.drawable.one)
            2 ->
                ferhjg.setBackgroundResource(R.drawable.two)
            3 ->
                ferhjg.setBackgroundResource(R.drawable.three)
            4 ->
                ferhjg.setBackgroundResource(R.drawable.four)
            5 ->
                ferhjg.setBackgroundResource(R.drawable.five)
        }
        when (ufherhfoerhf3) {
            1 ->
                bhtyhj57k.setBackgroundResource(R.drawable.one)
            2 ->
                bhtyhj57k.setBackgroundResource(R.drawable.two)
            3 ->
                bhtyhj57k.setBackgroundResource(R.drawable.three)
            4 ->
                bhtyhj57k.setBackgroundResource(R.drawable.four)
            5 ->
                bhtyhj57k.setBackgroundResource(R.drawable.five)

        }

    }

    private fun fcvry5yji7o() {

        if (ufherhfoerhf1 == ufherhfoerhf2 && ufherhfoerhf2 == ufherhfoerhf3) {
            val plus10k: Int = gb46j.text.toString().toInt()+10000
            Toast.makeText(this, "JACKPOT! +10000", Toast.LENGTH_SHORT).show()
            gb46j.text=plus10k.toString()
        }
        if(ufherhfoerhf1 == ufherhfoerhf2 || ufherhfoerhf2 == ufherhfoerhf3 || ufherhfoerhf1 == ufherhfoerhf3) {
            val plus2k: Int = gb46j.text.toString().toInt()+2000
            Toast.makeText(this, "+2000", Toast.LENGTH_SHORT).show()

            gb46j.text=plus2k.toString()
        }

    }
}