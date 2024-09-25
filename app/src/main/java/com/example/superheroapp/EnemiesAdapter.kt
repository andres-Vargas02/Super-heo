package com.example.superheroapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.data.models.Enemy

class EnemiesAdapter(
    private val enemies: List<Enemy>
) : RecyclerView.Adapter<EnemiesAdapter.EnemyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnemyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_enemy, parent, false)
        return EnemyViewHolder(view)
    }

    override fun onBindViewHolder(holder: EnemyViewHolder, position: Int) {
        val enemy = enemies[position]
        holder.bind(enemy)
    }

    override fun getItemCount(): Int = enemies.size

    inner class EnemyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val enemyName: TextView = itemView.findViewById(R.id.tvEnemyName)
        private val enemyImage: ImageView = itemView.findViewById(R.id.ivEnemyImage)

        fun bind(enemy: Enemy) {
            enemyName.text = enemy.name
            enemyImage.setImageResource(enemy.photo)
        }
    }
}
