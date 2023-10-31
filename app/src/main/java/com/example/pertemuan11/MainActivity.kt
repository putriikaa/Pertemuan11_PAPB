package com.example.pertemuan11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pertemuan11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapterDisaster = DisasterAdapter(generateDummy()) { disaster: Disaster ->
            Toast.makeText(
                this@MainActivity,
                "You clicked on ${disaster.nameDisaster}",
            Toast.LENGTH_SHORT
            ).show()
        }
        with(binding){
            rvDisaster.apply {
                adapter= adapterDisaster
                layoutManager = LinearLayoutManager(context)
            }
        }
    }
    private fun generateDummy(): List<Disaster>{
        return listOf(
            Disaster(nameDisaster = "Tsunami", disasterType = "natural"),
            Disaster(nameDisaster = "Volcanic Eruption", disasterType = "natural"),
            Disaster(nameDisaster = "Earthquake", disasterType = "natural"),
            Disaster(nameDisaster = "Flood", disasterType = "natural"),
            Disaster(nameDisaster = "Fire", disasterType = "natural"),
            Disaster(nameDisaster = "Nuclear Accident", disasterType = "Man-made"),
            Disaster(nameDisaster = "Terorist Attack", disasterType = "Man-Made"),
            Disaster(nameDisaster = "War", disasterType = "Man-Made"),

        )
    }
}