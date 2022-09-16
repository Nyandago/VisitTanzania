package com.cannybits.visittanzania


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout


class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    private lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // to make the Navigation drawer icon always appear on the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


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

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_settings -> {
                //settings()
                Toast.makeText(this, "Clicked Settings",Toast.LENGTH_LONG).show()
                true
            }

            R.id.nav_favorites -> {
                //favorites()
                Toast.makeText(this, "Clicked favorites",Toast.LENGTH_LONG).show()
                true
            }

            R.id.nav_logout -> {
                //logout()
                Toast.makeText(this, "Clicked logout",Toast.LENGTH_LONG).show()
                true
            }

            R.id.nav_user_icon -> {
                //userProfile
                Toast.makeText(this, "Clicked user icon",Toast.LENGTH_LONG).show()
                true
            }


            // return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            //        true
            //     }
            else -> super.onOptionsItemSelected(item)
        }




    }

}
