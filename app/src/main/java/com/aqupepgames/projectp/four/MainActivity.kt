package com.aqupepgames.projectp.four

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.aqupepgames.projectp.R
import com.aqupepgames.projectp.four.acti.RegAct
import com.aqupepgames.projectp.four.acti.WeAct
import com.aqupepgames.projectp.four.utils.SortClass
import com.aqupepgames.projectp.four.vm.ViewMainModel
import kotlinx.coroutines.*
import okhttp3.internal.wait
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewMainModel by viewModel<ViewMainModel>()

        lifecycleScope.launch (Dispatchers.IO){
           viewMainModel.jobMain.join()
        }


        viewMainModel.initAppsFlyerLib(this@MainActivity)


        viewMainModel.currentMode.observe(this) {
            Log.d("CURRENTMODE", "onCreate: ${viewMainModel.currentMode}")
            when (it) {
                SortClass.REAL_START -> {
                    Toast.makeText(this, "${viewMainModel.appsCh}, ${viewMainModel.linka}, ${viewMainModel.couData}", Toast.LENGTH_SHORT).show()
                    startWeb()
                }
                SortClass.MODERATION -> {
                    startGame()
                }
                SortClass.REAL_START_NO_APPS -> {
                    startWeb()
                }
            }
        }


    }

    private fun startWeb() {
        startActivity(Intent(this, WeAct::class.java))
        finish()
    }

    private fun startGame() {
        startActivity(Intent(this, RegAct::class.java))
        finish()
    }



}