package com.aqupepgames.projectp.one

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aqupepgames.projectp.databinding.FragmentSettingsBinding
import com.google.android.material.snackbar.Snackbar


class SettingsFragment : Fragment() {
    private fun vvvvv() {
        Snackbar.make(
            xxxxxx.root,
            "Error 505...reloading...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }

    private var kkkk: FragmentSettingsBinding? = null
    private val xxxxxx get() = kkkk ?: throw RuntimeException("FragmentSettingsBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        kkkk = FragmentSettingsBinding.inflate(inflater, container, false)
        return xxxxxx.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            xxxxxx.btnImgExit.setOnClickListener {
                requireActivity().onBackPressed()
            }



        } catch (e: Exception) {
            vvvvv()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        kkkk = null
        super.onDestroy()
    }

}