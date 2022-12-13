package com.aqupepgames.projectp.one

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.aqupepgames.projectp.R
import com.aqupepgames.projectp.databinding.FragmentInitBinding
import com.google.android.material.snackbar.Snackbar

class InitFragment : Fragment() {

    private fun gthyhuyjuju() {
        Snackbar.make(
            ssskkaa.root,
            "Error 505...reloading...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }

    private var nhnhnh: FragmentInitBinding? = null
    private val ssskkaa get() = nhnhnh ?: throw RuntimeException("FragmentInitBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        nhnhnh = FragmentInitBinding.inflate(inflater, container, false)
        return ssskkaa.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            ssskkaa.btnPlayGameeee.setOnClickListener {
                findNavController().navigate(R.id.action_initFragment_to_playGaaaameFragment)
            }

            ssskkaa.imgInfo.setOnClickListener {
                findNavController().navigate(R.id.action_initFragment_to_aboutFragment)
            }
            ssskkaa.imgsettings.setOnClickListener {
                findNavController().navigate(R.id.action_initFragment_to_settingsFragment)
            }
            ssskkaa.imleader.setOnClickListener {
                findNavController().navigate(R.id.action_initFragment_to_bestScoresFragment)
            }

        } catch (e: Exception) {
            gthyhuyjuju()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        nhnhnh = null
        super.onDestroy()
    }

}