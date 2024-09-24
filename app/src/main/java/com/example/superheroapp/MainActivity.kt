package com.example.superheroapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.data.generateSuperheroes
import com.example.superheroapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Generamos la lista de superhéroes
        val superheroes = generateSuperheroes()

        // Configuramos el RecyclerView
        binding.rvHero.layoutManager = LinearLayoutManager(this)
        binding.rvHero.adapter = SuperheroAdapter(superheroes)
    }
}
