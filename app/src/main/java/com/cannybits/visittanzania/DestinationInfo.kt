package com.cannybits.visittanzania

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_destination_info.*

class DestinationInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination_info)

        val bundle: Bundle? = intent.extras
        val name = bundle!!.getString("name")
        val desc = bundle.getString("desc")
        val image = bundle.getInt("image")

        imgDestination.setImageResource(image)
        tvDestDetails.text = desc
        tvDestName.text = name


    }
}