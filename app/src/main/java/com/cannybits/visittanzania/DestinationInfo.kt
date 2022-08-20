package com.cannybits.visittanzania

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView



class DestinationInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination_info)

        val imgDest = findViewById<ImageView>(R.id.imgDestination)
        val tvDestinationDetails = findViewById<TextView>(R.id.tvDestType)
        val tvDestinationName = findViewById<TextView>(R.id.tvDestName)


        val bundle: Bundle? = intent.extras
        val name = bundle!!.getString("name")
        val desc = bundle.getString("desc")
        val image = bundle.getInt("image")

        imgDest.setImageResource(image)
        tvDestinationDetails.text = desc
        tvDestinationName.text = name


    }
}