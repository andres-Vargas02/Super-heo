package com.example.superheroapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.data.models.Superhero

class SuperheroAdapter(
    private val superheroes: List<Superhero>
) : RecyclerView.Adapter<SuperheroAdapter.SuperheroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hero, parent, false)
        return SuperheroViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        val superhero = superheroes[position]
        holder.bind(superhero)
    }

    override fun getItemCount(): Int = superheroes.size

    inner class SuperheroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val superheroName: TextView = itemView.findViewById(R.id.tvSuperHeroName)
        private val superheroImage: ImageView = itemView.findViewById(R.id.ivSuperHeroImage)
        private val btnPowers: Button = itemView.findViewById(R.id.btnPowers)
        private val btnFriends: Button = itemView.findViewById(R.id.btnFriends)
        private val btnEnemies: Button = itemView.findViewById(R.id.btnEnemies)
        private val btnLocations: Button = itemView.findViewById(R.id.btnLocations)

        fun bind(superhero: Superhero) {
            superheroName.text = superhero.name
            superheroImage.setImageResource(superhero.photo)

            // Listener para abrir la actividad de Poderes
            btnPowers.setOnClickListener {
                val intent = Intent(itemView.context, PowersActivity::class.java)
                intent.putIntegerArrayListExtra("powers", ArrayList(superhero.powers))
                itemView.context.startActivity(intent)
            }

            // Listener para abrir la actividad de Amigos
            btnFriends.setOnClickListener {
                val intent = Intent(itemView.context, FriendsActivity::class.java)
                intent.putIntegerArrayListExtra("friends", ArrayList(superhero.friends))
                itemView.context.startActivity(intent)
            }

            // Listener para abrir la actividad de Enemigos
            btnEnemies.setOnClickListener {
                val intent = Intent(itemView.context, EnemiesActivity::class.java)
                intent.putIntegerArrayListExtra("enemies", ArrayList(superhero.enemies))
                itemView.context.startActivity(intent)
            }

            // Listener para abrir la actividad de Ubicaciones
            btnLocations.setOnClickListener {
                val intent = Intent(itemView.context, LocationsActivity::class.java)
                intent.putIntegerArrayListExtra("locations", ArrayList(superhero.locations))
                itemView.context.startActivity(intent)

            }
        }
    }
}
