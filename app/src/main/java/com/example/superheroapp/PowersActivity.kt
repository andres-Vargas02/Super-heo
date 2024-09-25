package com.example.superheroapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.data.generatePowers
import com.example.superheroapp.databinding.ActivityPowersBinding

class PowersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPowersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPowersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val powerIds = intent.getIntegerArrayListExtra("powers") ?: arrayListOf()
        val allPowers = generatePowers()
        val selectedPowers = allPowers.filter { powerIds.contains(it.id) }

        binding.rvPowers.layoutManager = LinearLayoutManager(this)
        binding.rvPowers.adapter = PowersAdapter(selectedPowers)
    }
}
