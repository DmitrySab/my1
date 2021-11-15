package com.example.my1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import android.content.pm.PackageManager

class CityViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    fun bind(city: City){
    val cityNameTextView :TextView =itemView.findViewById(R.id.city_name_text_view)
    cityNameTextView.text = city.cityName

        itemView.setOnClickListener {
            Toast.makeText(itemView.context, city.population.toString(), Toast.LENGTH_LONG).show()
        }

        val cityMap : ImageButton = itemView.findViewById(R.id.city_map_button)
        cityMap.setOnClickListener{
            val geoUriString = "geo:${city.coordiate}?z=10"
            val geoUri: Uri = Uri.parse(geoUriString)
            val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)
            startActivity(itemView.context,mapIntent, Bundle())
            if (mapIntent.resolveActivity(itemView.context.packageManager) != null)
                startActivity(itemView.context,mapIntent, Bundle())
            else
                Toast.makeText(itemView.context, "Нечем открыть карту", Toast.LENGTH_LONG).show()
        }


    }

}