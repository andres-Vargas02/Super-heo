package com.example.superheroapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.data.generateLocations
import com.example.superheroapp.databinding.ActivityLocationsBinding

class LocationsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLocationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val locationIds = intent.getIntegerArrayListExtra("locations") ?: arrayListOf()
        val allLocations = generateLocations()
        val locations = allLocations.filter { locationIds.contains(it.id) }

        binding.rvLocations.layoutManager = LinearLayoutManager(this)
        binding.rvLocations.adapter = LocationsAdapter(locations)

    }
}
