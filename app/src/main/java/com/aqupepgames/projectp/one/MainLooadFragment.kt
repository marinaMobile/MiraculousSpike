package com.aqupepgames.projectp.one

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.aqupepgames.projectp.R
import com.aqupepgames.projectp.databinding.FragmentMainLooadBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainLooadFragment : Fragment() {
    private fun hyhyhyhy() {
        lifecycleScope.launch {
            for (progress in 1..100) {
                withContext(Dispatchers.Main) {
                    yyyyy.progBarSplashScrn.progress = progress
                }
                delay(SPLASH_SCREEN_TIMEggtgttg / 125)
            }
            //here add
            findNavController().navigate(R.id.action_mainLooadFragment_to_initFragment)
        }
    }

    companion object {
        private const val SPLASH_SCREEN_TIMEggtgttg: Long = 1500
    }

    private var dddd: FragmentMainLooadBinding? = null
    private val yyyyy
        get() = dddd ?: throw RuntimeException("FragmentMainLooadBinding = null")


    private fun eeeeeeee() {
        Snackbar.make(
            yyyyy.root,
            "Error, error, error",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dddd = FragmentMainLooadBinding.inflate(inflater, container, false)
        return yyyyy.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            hyhyhyhy()


        } catch (e: Exception) {
            eeeeeeee()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        dddd = null
        super.onDestroy()
    }
}