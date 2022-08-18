package com.cannybits.visittanzania

import android.content.Context
import org.json.JSONException
import org.json.JSONObject

class DestinationTz(
    val title: String,
    val description: String,
    val imageUrl: String,
    val destType: String,
    val destActivities: String) {

    companion object {

        fun getRecipesFromFile(filename: String, context: Context): ArrayList<DestinationTz> {
            val destinationList = ArrayList<DestinationTz>()

            try {
                // Load data
                val jsonString = loadJsonFromAsset("destinations.json", context)
                val json = jsonString?.let { JSONObject(it) }
                val destinations = json?.getJSONArray("destinations")

                // Get Recipe objects from data
                if (destinations != null) {
                    (0 until destinations.length()).mapTo(destinationList) {
                        DestinationTz(destinations.getJSONObject(it).getString("title"),
                            destinations.getJSONObject(it).getString("description"),
                            destinations.getJSONObject(it).getString("imageUrl"),
                            destinations.getJSONObject(it).getString("destType"),
                            destinations.getJSONObject(it).getString("activities"))
                    }
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return destinationList
        }

        private fun loadJsonFromAsset(filename: String, context: Context): String? {
            var json: String? = null

            try {
                val inputStream = context.assets.open(filename)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, Charsets.UTF_8)
            } catch (ex: java.io.IOException) {
                ex.printStackTrace()
                return null
            }

            return json
        }
    }
}