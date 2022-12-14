package com.aqupepgames.projectp.four

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aqupepgames.projectp.R
import com.aqupepgames.projectp.four.vm.ViewMainModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewMainModel by viewModel<ViewMainModel>()

    }
}