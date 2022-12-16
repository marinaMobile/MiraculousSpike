package com.aqupepgames.projectp.four.inapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.aqupepgames.projectp.AppClass
import com.aqupepgames.projectp.databinding.ActivityProductListingBinding
import com.aqupepgames.projectp.four.acti.RegAct
import com.qonversion.android.sdk.Qonversion
import com.qonversion.android.sdk.Qonversion.purchase
import com.qonversion.android.sdk.QonversionError
import com.qonversion.android.sdk.QonversionOfferingsCallback
import com.qonversion.android.sdk.QonversionPermissionsCallback
import com.qonversion.android.sdk.dto.QPermission
import com.qonversion.android.sdk.dto.offerings.QOfferings
import com.qonversion.android.sdk.dto.products.QProduct

class ProductListing : AppCompatActivity() {

    lateinit var binding: ActivityProductListingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewProductsList.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewProductsList.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )



        Qonversion.offerings(object : QonversionOfferingsCallback {
            override fun onSuccess(offerings: QOfferings) {
                val mainProducts = offerings.main?.products
                mainProducts?.let {
                    binding.recyclerViewProductsList.adapter = ProductsAdapter(it) { product ->
                        purchase(product)
                    }

                } ?:  Toast.makeText(this@ProductListing, "There are no products in main offering", Toast.LENGTH_LONG).show()
            }

            override fun onError(error: QonversionError) {
                Toast.makeText(this@ProductListing, error.description, Toast.LENGTH_LONG).show()

            }
        })
    }


    private fun purchase(product: QProduct) {
        purchase(this, product, callback = object :
            QonversionPermissionsCallback {
            override fun onSuccess(entitlements: Map<String, QPermission>) {
                Toast.makeText(this@ProductListing, "Purchase succeeded", Toast.LENGTH_LONG).show()
                if (product.qonversionID == "coin_offer_s"){
                    val totalBalanceSP = getSharedPreferences("TOTAL_BAL_SP", MODE_PRIVATE)
                    val totalB = totalBalanceSP.getInt(AppClass.TOTAL_BALANCE.toString(), 0)
                    totalBalanceSP.edit().putInt(AppClass.TOTAL_BALANCE.toString(), totalB+200).apply()
                }
                if (product.qonversionID == "coin_offer_m"){
                    val totalBalanceSP = getSharedPreferences("TOTAL_BAL_SP", MODE_PRIVATE)
                    val totalB = totalBalanceSP.getInt(AppClass.TOTAL_BALANCE.toString(), 0)
                    totalBalanceSP.edit().putInt(AppClass.TOTAL_BALANCE.toString(), totalB+600).apply()
                }
                if (product.qonversionID == "coin_offer_l"){
                    val totalBalanceSP = getSharedPreferences("TOTAL_BAL_SP", MODE_PRIVATE)
                    val totalB = totalBalanceSP.getInt(AppClass.TOTAL_BALANCE.toString(), 0)
                    totalBalanceSP.edit().putInt(AppClass.TOTAL_BALANCE.toString(), totalB+1200).apply()
                }
                if (product.qonversionID == "coin_offer_xl"){
                    val totalBalanceSP = getSharedPreferences("TOTAL_BAL_SP", MODE_PRIVATE)
                    val totalB = totalBalanceSP.getInt(AppClass.TOTAL_BALANCE.toString(), 0)
                    totalBalanceSP.edit().putInt(AppClass.TOTAL_BALANCE.toString(), totalB+2500).apply()
                }
            }
            override fun onError(error: QonversionError) {
                Toast.makeText(this@ProductListing, "Purchase was unsuccessful. Try Again Later!", Toast.LENGTH_LONG).show()

            }
        })
    }


    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, RegAct::class.java))
        finish()
    }
}