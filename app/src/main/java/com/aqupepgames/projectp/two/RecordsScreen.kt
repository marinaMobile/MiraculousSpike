package com.aqupepgames.projectp.two

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.aqupepgames.projectp.databinding.ActivityRecordsScreenBinding

class RecordsScreen : AppCompatActivity() {
    private lateinit var jjsdnds : ActivityRecordsScreenBinding
    private var woskdaksad : RcAdapterSec? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        jjsdnds = ActivityRecordsScreenBinding.inflate(layoutInflater)
        setContentView(jjsdnds.root)
        rcInstance()
        jjsdnds.button.setOnClickListener {
            startActivity(Intent(this,ThreeGame::class.java))
        }
    }


    private fun rcInstance() = with(jjsdnds){
        woskdaksad = RcAdapterSec(ListRcData.secGameData,this@RecordsScreen)
        rcViewSec.layoutManager = LinearLayoutManager(this@RecordsScreen,LinearLayoutManager.VERTICAL,false)
        rcViewSec.adapter = woskdaksad
    }
}