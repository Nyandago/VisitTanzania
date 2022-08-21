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
        val tvDestinationDetails = findViewById<TextView>(R.id.tvDestDetails)
        val tvDestinationName = findViewById<TextView>(R.id.tvDestName)
        val tvDestType = findViewById<TextView>(R.id.tvDestType)
        val tvDestActivities = findViewById<TextView>(R.id.tvDestActivities)



        val bundle: Bundle? = intent.extras
        val name = bundle!!.getString("name")
        val desc = bundle.getString("desc")
        val image = bundle.getInt("image")
        val desType = bundle.getString("desType")
        val desActivities = bundle.getString("desActivity")

        imgDest.setImageResource(image)
        tvDestinationDetails.text = desc
        tvDestinationName.text = name
        tvDestType.text = desType
        tvDestActivities.text = desActivities


    }
}