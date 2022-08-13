package com.cannybits.visittanzania

import android.content.Context
import android.content.Intent
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
            DestinationTz("Mount Kilimanjaro","It is the highest mountain in Africa.\nThe highest single free-standing mountain in the world.\n5,895 metres (19,341 ft) above sea level and about 4,900 metres (16,100 ft) above its plateau base.",
        R.drawable.kilimanjaro,false)
        )
        destinationList.add(DestinationTz("Serengeti National Park","Serengeti National Park is a World Heritage Site teeming with wildlife:\nOver 2 million ungulates, 4000 lions, 1000 leopard, 550 cheetahs and some 500 bird species inhabit an area close to 15,000 square kilometers in size.\nSerengeti National Park, in northern Tanzania, is known for its massive annual migration of wildebeest and zebra. Seeking new pasture, the herds move north from their breeding grounds in the grassy southern plains. ",
            R.drawable.serengeti,true))
        destinationList.add(DestinationTz("Mikumi National Park","Located between the Uluguru Mountains and the Lumango range, Mikumi is the fourth largest national park in Tanzania and only a few hours drive from Tanzania’s largest city.\nMost visitors come to Mikumi National Park aiming to spot the ‘Big Five’ (cheetah, lion, elephant, buffalo, and rhino), and they are always not disappointed.\nWith almost guaranteed wildlife sightings, it makes an ideal safari destination for those without much time.",
            R.drawable.mikumi,true))
        destinationList.add(DestinationTz("Ngorongoro Conservation Area","The Ngorongoro Conservation Area, is a protected area and a World Heritage Site located 180 km (110 mi) west of Arusha in the Crater Highlands area of Tanzania.\nThe area is named after Ngorongoro Crater, a large volcanic caldera within the area.",
            R.drawable.ngorongoro,true))
        destinationList.add(DestinationTz("Zanzibar Island","Zanzibar is one of the Indian Ocean islands.\nIt is situated on the Swahili Coast, adjacent to Tanganyika (mainland Tanzania).\nIt is the main island in the Tanzanian archipelago of Zanzibar.\nStone Town, part of Zanzibar City, is an old trade center, with mosques and winding lanes.\nThe 1883 House of Wonders is a former sultan’s palace with a clock tower.\nThe Old Fort now houses a cultural center and a stone amphitheater.\nUnderground aqueducts fed hot water to the late-19th-century Hamamni Persian Baths.",
            R.drawable.zanzibar, false))
        destinationList.add(DestinationTz("Tarangire National Park","Tarangire National Park is a national park in Tanzania's Manyara Region.\nThe name of the park originates from the Tarangire River that crosses the park.\nThe Tarangire River is the primary source of fresh water for wild animals in the Tarangire Ecosystem during the annual dry season.\nThe Tarangire National Park is most popular for its large elephant herds and mini-wildlife migration that takes place during the dry season which sees about 250,000 animals enter the park.",
            R.drawable.tarangire,true))
        destinationList.add(DestinationTz("Magoroto Forest Estate","The 591 hectares sized Magoroto Forest Estate with its scenic freshwater lake has been opened in 1896 by German Settlers as one of the very first commercial plantations in Eastern Africa.\n Seized from the German owners as “enemy property” after World War 1 the Estate has been taken over by the Amboni Group in the 1940s\nThey are recognized as part of a Biodiversity Hotspot (WWF & IUCN), an “Important Bird Area” (Wildlife Conservation Society of Tanzania – WCST) and a “Man and Biosphere Reserve (UNESCO).",
            R.drawable.magoroto, false))

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
        if(destination.isNationalPark == true){
            var inflater =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflater.inflate(R.layout.destination_nat_park_ticket, null)
            myView.tvName.text = destination.name!!
            myView.tvDesc.text = destination.description!!
            myView.imgDestinationName.setImageResource(destination.image!!)
            myView.imgDestinationName.setOnClickListener{
                val intent = Intent(context,DestinationInfo::class.java)
                intent.putExtra("name",destination.name)
                intent.putExtra("desc",destination.description)
                intent.putExtra("image",destination.image)
                context!!.startActivity(intent)
            }
            return myView
        } else
        {
            var inflater =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflater.inflate(R.layout.destination_ticket, null)
            myView.tvName.text = destination.name!!
            myView.tvDesc.text = destination.description!!
            myView.imgDestinationName.setImageResource(destination.image!!)
            myView.imgDestinationName.setOnClickListener{
                val intent = Intent(context,DestinationInfo::class.java)
                intent.putExtra("name",destination.name)
                intent.putExtra("desc",destination.description)
                intent.putExtra("image",destination.image)
                context!!.startActivity(intent)
            }
            return myView
        }
    }
}