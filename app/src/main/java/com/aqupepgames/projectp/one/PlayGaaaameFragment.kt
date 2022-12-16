package com.aqupepgames.projectp.one

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.aqupepgames.projectp.AppClass
import com.aqupepgames.projectp.AppClass.Companion.TOTAL_BALANCE
import com.aqupepgames.projectp.R
import com.aqupepgames.projectp.databinding.FragmentPlayGaaaameBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


class PlayGaaaameFragment : Fragment() {

    var totalBalance = 0
    var userBet = 50

    val ooooo by lazy {
        mapOf(
            "one" to ContextCompat.getDrawable(requireActivity(), R.drawable.a1),
            "tvo" to ContextCompat.getDrawable(requireActivity(), R.drawable.a2),
            "three" to ContextCompat.getDrawable(requireActivity(), R.drawable.a3),
            "four" to ContextCompat.getDrawable(requireActivity(), R.drawable.a4),
        )
    }


    private fun createAnimatorSetBack(): AnimatorSet {
        return AnimatorInflater.loadAnimator(
            requireContext().applicationContext,
            R.animator.back_animator
        ) as AnimatorSet
    }

    private fun createAnimatorSetFront(): AnimatorSet {
        return AnimatorInflater.loadAnimator(
            requireContext().applicationContext,
            R.animator.front_animator
        ) as AnimatorSet
    }

    private val bgbgvvfv by lazy {
        createAnimatorSetFront()
    }

    private val xcvvvv by lazy {
        createAnimatorSetBack()
    }

    private fun fanka(
        frontAnim: AnimatorSet,
        backAnim: AnimatorSet,
        elemFront: ImageView,
        elemBack: ImageView
    ) {
        frontAnim.setTarget(elemBack)
        backAnim.setTarget(elemFront)
        frontAnim.start()
        backAnim.start()
    }

    private fun mashaa() {
        fanka(
            bgbgvvfv,
            xcvvvv,
            bindinggg.imgElem1,
            bindinggg.imgElem1Back
        )
    }

    private fun mashaa1() {
        fanka(
            bgbgvvfv,
            xcvvvv,
            bindinggg.imgElem2,
            bindinggg.imgElem2Back
        )
    }


    private var _bindinggg: com.aqupepgames.projectp.databinding.FragmentPlayGaaaameBinding? = null
    private val bindinggg
        get() = _bindinggg ?: throw RuntimeException("FragmentPlayGaaaameBinding = null")

    private fun manka() {
        bvbvbbvvbvbvb(
            bgbgvvfv, xcvvvv, bindinggg.imgElem1, bindinggg.imgElem1Back
        )
    }

    private fun bvbvbbvvbvbvb(
        frontAnim: AnimatorSet,
        backAnim: AnimatorSet,
        elemFront: ImageView,
        elemBack: ImageView
    ) {
        frontAnim.setTarget(elemFront)
        backAnim.setTarget(elemBack)
        frontAnim.start()
        backAnim.start()
    }

    private val vfvfvffv by lazy {
        createAnimatorSetFront()
    }

    private val nhbbbbggb by lazy {
        createAnimatorSetBack()
    }


    private fun bgbgbgffff() {
        bvbvbbvvbvbvb(
            vfvfvffv, nhbbbbggb, bindinggg.imgElem2, bindinggg.imgElem2Back
        )
    }

    private fun pasha() {
        fanka(
            vfvfvffv,
            nhbbbbggb,
            bindinggg.imgElem2,
            bindinggg.imgElem2Back
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindinggg = FragmentPlayGaaaameBinding.inflate(inflater, container, false)
        return bindinggg.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindinggg.tvUserBetNumber.text = userBet.toString()

        val totalBalanceSP = requireActivity().getSharedPreferences("TOTAL_BAL_SP",
            Context.MODE_PRIVATE
        )
        totalBalance = totalBalanceSP.getInt(TOTAL_BALANCE.toString(), 0)

        bindinggg.tvUserScoreCount.text = totalBalance.toString()

//        val user = ooooo.keys.random()
//        val comppp = ooooo.keys.random()
//
//        bindinggg.imgElem1Back.setImageDrawable(ooooo.get(comppp))
//        bindinggg.imgElem2Back.setImageDrawable(ooooo.get(user))

        bindinggg.btnGame.isEnabled = true

        bindinggg.btnGame.setOnClickListener {
            val user22 = ooooo.keys.random()
            val comppp222 = ooooo.keys.random()
            bindinggg.imgElem1Back.setImageDrawable(ooooo.get(comppp222))
            bindinggg.imgElem2Back.setImageDrawable(ooooo.get(user22))

            if (totalBalance >0 && totalBalance>=userBet) {
                bindinggg.btnGame.isEnabled = false
                manka()
                bgbgbgffff()
                lifecycleScope.launch {
                    delay(2000)
                    mashaa()
                    pasha()
                    bindinggg.btnGame.isEnabled = true

                    if (user22 == comppp222){
                        totalBalance = totalBalance + userBet
                        Snackbar.make(
                            bindinggg.root,
                            "You win ${userBet}$",
                            Snackbar.LENGTH_LONG
                        ).show()
                        val editPref = totalBalanceSP.edit()
                        editPref.putInt(TOTAL_BALANCE.toString(), totalBalance)
                        editPref.apply()
                    } else {
                        totalBalance = totalBalance - userBet
                        Snackbar.make(
                            bindinggg.root,
                            "You lose ${userBet}$",
                            Snackbar.LENGTH_LONG
                        ).show()
                        val editPref = totalBalanceSP.edit()
                        editPref.putInt(TOTAL_BALANCE.toString(), totalBalance)
                        editPref.apply()
                    }
                    bindinggg.tvUserScoreCount.text = totalBalance.toString()
                }

                val editPref = totalBalanceSP.edit()
                editPref.putInt(TOTAL_BALANCE.toString(), totalBalance)
                editPref.apply()

            } else {
                Snackbar.make(
                    bindinggg.root,
                    "Your balance is less than 10",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

        bindinggg.removeBet.setOnClickListener {
            if (userBet >= 20) {
                userBet -= 10
                bindinggg.tvUserBetNumber.text = userBet.toString()
            }else{
                Snackbar.make(
                    bindinggg.root,
                    "Bet can`t be lower than 10",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

        bindinggg.addBet.setOnClickListener {
            userBet = userBet + 10
            bindinggg.tvUserBetNumber.text = userBet.toString()

        }

        initExitBtnbgbg()


        super.onViewCreated(view, savedInstanceState)
    }


    private fun initExitBtnbgbg() {

    }

//                override fun onAnimationEnd(p0: Animation?) {
//                    val userResult = sectorsgtgt[winnerNumber]
//                    Toast.makeText(
//                        requireContext(),
//                        "$userResult$",
//                        Toast.LENGTH_SHORT
//                    )
//                        .show()
//                    isSpinninggg = false
//
//                    userScore += userResult
//                    bindinggg.userScoreCount.text = userScore.toString()
//
//                }
//                override fun onAnimationRepeat(p0: Animation?) {
//                }
//            })
//            bindinggg.imgWheelElementMain.startAnimation(rotateAnimationgttg)
//        }
//    }

    override fun onDestroy() {
        _bindinggg = null
        super.onDestroy()
    }
//
//    private fun bgbggbbggb() {
//        for (i in sectorsgtgt.indices) {
//            sectorDegrees55[i] = (i + 1) * singleSectorDegree88
//        }
//    }
}