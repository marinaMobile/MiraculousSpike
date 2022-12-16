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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindMachineGame = ActivityTwoGameBinding.inflate(layoutInflater)
        setContentView(bindMachineGame.root)
    }
}