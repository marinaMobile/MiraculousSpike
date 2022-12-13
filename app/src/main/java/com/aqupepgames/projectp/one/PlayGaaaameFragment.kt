package com.aqupepgames.projectp.one

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.Toast
import com.aqupepgames.projectp.databinding.FragmentPlayGaaaameBinding
import kotlin.random.Random


class PlayGaaaameFragment : Fragment() {

    var userScore = OneGame.currentBalance


    private val sectorsgtgt = arrayOf(700, 1000, -100, 200, -500)
    private val sectorDegrees55 = sectorsgtgt.clone()
    private val singleSectorDegree88 = 360 / sectorsgtgt.size
    private var isSpinninggg = false

    private var _bindinggg: FragmentPlayGaaaameBinding? = null
    private val bindinggg get() = _bindinggg ?: throw RuntimeException("FragmentPlayGaaaameBinding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindinggg = FragmentPlayGaaaameBinding.inflate(inflater, container, false)
        return bindinggg.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        bindinggg.userScoreCount.text = userScore.toString()

        initExitBtnbgbg()
        bgbggbbggb()
        bindinggg.btnGameFortuneSpin.setOnClickListener {
            if (!isSpinninggg) {
                nnnnnnnsppiin()
                isSpinninggg = true
            }
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun initExitBtnbgbg() {
        bindinggg.btnImgExitVheelGame.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun nnnnnnnsppiin() {
        val winnerNumber = Random.nextInt(sectorsgtgt.size - 1)

        val needAddRotategttg = (360 - winnerNumber * singleSectorDegree88).toFloat()
        val rotateAnimationgttg = RotateAnimation(
            0f,
            (360f * sectorsgtgt.size) + needAddRotategttg,
            RotateAnimation.RELATIVE_TO_SELF,
            0.5f,
            RotateAnimation.RELATIVE_TO_SELF,
            0.5f
        )
        rotateAnimationgttg.apply {
            duration = 1000
            fillAfter = true
            interpolator = DecelerateInterpolator()
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {
                    val userResult = sectorsgtgt[winnerNumber]
                    Toast.makeText(
                        requireContext(),
                        "$userResult$",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    isSpinninggg = false

                    userScore += userResult
                    bindinggg.userScoreCount.text = userScore.toString()

                }
                override fun onAnimationRepeat(p0: Animation?) {
                }
            })
            bindinggg.imgWheelElementMain.startAnimation(rotateAnimationgttg)
        }
    }

    override fun onDestroy() {
        _bindinggg = null
        super.onDestroy()
    }

    private fun bgbggbbggb() {
        for (i in sectorsgtgt.indices) {
            sectorDegrees55[i] = (i + 1) * singleSectorDegree88
        }
    }
}