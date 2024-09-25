package com.example.superheroapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.data.generateSuperheroes
import com.example.superheroapp.databinding.ActivityFriendsBinding

class FriendsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFriendsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFriendsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val friendIds = intent.getIntegerArrayListExtra("friends") ?: arrayListOf()
        val allSuperheroes = generateSuperheroes(this)
        val friends = allSuperheroes.filter { friendIds.contains(it.id) }

        binding.rvFriends.layoutManager = LinearLayoutManager(this)
        binding.rvFriends.adapter = FriendsAdapter(friends)

    }
}
