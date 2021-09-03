package com.cannybits.visittanzania

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.destination_ticket.view.*

class MainActivity : AppCompatActivity() {

    var destinationList = ArrayList<DestinationTz>()
    var adapter: DestinationAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load destinations
        destinationList.add(
            DestinationTz("Mount Kilimanjaro","The Highest Free standing mountain in the world",
        R.drawable.kilimanjaro)
        )
        destinationList.add(DestinationTz("Serengeti National Park","Wild beast,zebra migration",
            R.drawable.serengeti))
        destinationList.add(DestinationTz("Mikumi National Park","The fourth largest national park in Tanzania",
            R.drawable.mikumi))
        destinationList.add(DestinationTz("Ngorongoro Crater","Amazing Crater with Lions, Rhinos, Zebra, Leopards and so much more",
            R.drawable.ngorongoro))
        destinationList.add(DestinationTz("Zanzibar Island","Experience the Heaven on earth feeling",
            R.drawable.zanzibar))
        destinationList.add(DestinationTz("Tarangire National Park","The home of the giant Elephants",
            R.drawable.tarangire))
        destinationList.add(DestinationTz("Magoroto Forest","Get Lost in the jungle",
            R.drawable.magoroto))

        adapter = DestinationAdapter(this, destinationList)
        tvListDestinations.adapter = adapter
    }
}

class DestinationAdapter : BaseAdapter{

    var destinationList = ArrayList<DestinationTz>()
    var context:Context? = null

    constructor(context: Context, destinationList : ArrayList<DestinationTz>): super(){
        this.destinationList = destinationList
        this.context = context
    }

    override fun getCount(): Int {
       return destinationList.size
    }

    override fun getItem(position: Int): Any {
      return destinationList[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val destination = destinationList[position]
        var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var myView = inflater.inflate(R.layout.destination_ticket, null)
        myView.tvName.text = destination.name!!
        myView.tvDesc.text = destination.description!!
        myView.imgDestinationName.setImageResource(destination.image!!)
         return myView
    }
}