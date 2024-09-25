package com.example.superheroapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.data.generateEnemies
import com.example.superheroapp.databinding.ActivityEnemiesBinding

class EnemiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEnemiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnemiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val enemyIds = intent.getIntegerArrayListExtra("enemies") ?: arrayListOf()
        val allEnemies = generateEnemies()
        val enemies = allEnemies.filter { enemyIds.contains(it.id) }

        binding.rvEnemies.layoutManager = LinearLayoutManager(this)
        binding.rvEnemies.adapter = EnemiesAdapter(enemies)
    }
}
