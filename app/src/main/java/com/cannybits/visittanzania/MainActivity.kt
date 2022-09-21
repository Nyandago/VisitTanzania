package com.cannybits.visittanzania


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout



class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lvDestinationTz)
        val destinationList = DestinationTz.getRecipesFromFile("destinations.json", this)

        val adapter = DestinationAdapter(this, destinationList)
        listView.adapter = adapter


        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedDestination = destinationList[position]

            val intent = Intent(this, DestinationInfo::class.java)

            // To pass any data to next activity
            intent.putExtra("name", selectedDestination.title)
            intent.putExtra("desc", selectedDestination.description)
            intent.putExtra("image", selectedDestination.imageUrl)
            intent.putExtra("descType", selectedDestination.destType)
            intent.putExtra("descActivity", selectedDestination.destActivities)

//            Toast.makeText(this, "Selected ${selectedDestination.imageUrl}", Toast.LENGTH_LONG).show()
            startActivity(intent)
        }


    }


}


