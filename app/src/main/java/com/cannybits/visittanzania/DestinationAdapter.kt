package com.cannybits.visittanzania.a

import android.annotation.SuppressLint
import android.content.Context
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.cannybits.visittanzania.DestinationTz
import com.cannybits.visittanzania.R
import com.squareup.picasso.Picasso

class DestinationAdapter(private val context: Context, private val datasource: ArrayList<DestinationTz>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater



    override fun getCount(): Int {
        return datasource.size
    }

    override fun getItem(position: Int): Any {
        return datasource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val rowView = inflater.inflate(R.layout.destination_ticket, parent, false)

            val titleTextView = rowView.findViewById(R.id.tvName) as TextView
            val descriptionTextView = rowView.findViewById(R.id.tvDesc) as TextView
            val imageView = rowView.findViewById(R.id.imgDestinationName) as ImageView

            val destination = getItem(position) as DestinationTz
            titleTextView.text = destination.title
            descriptionTextView.text = destination.description

            Picasso.with(context).load(destination.imageUrl).placeholder(R.mipmap.ic_launcher).into(imageView)

            return rowView

    }
}