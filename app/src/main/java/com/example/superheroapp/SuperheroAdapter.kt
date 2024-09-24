package com.example.superheroapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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
            superheroImage.setImageResource(superhero.photo) // Asignamos la imagen del superhéroe

            // Listener para el botón de Poderes
            btnPowers.setOnClickListener {
                Toast.makeText(itemView.context, "${superhero.name} tiene estos poderes: ${superhero.powers}", Toast.LENGTH_SHORT).show()
            }

            // Listener para el botón de Amigos
            btnFriends.setOnClickListener {
                Toast.makeText(itemView.context, "Amigos de ${superhero.name}: ${superhero.friends}", Toast.LENGTH_SHORT).show()
            }

            // Listener para el botón de Enemigos
            btnEnemies.setOnClickListener {
                Toast.makeText(itemView.context, "Enemigos de ${superhero.name}: ${superhero.enemies}", Toast.LENGTH_SHORT).show()
            }

            // Listener para el botón de Ubicaciones
            btnLocations.setOnClickListener {
                Toast.makeText(itemView.context, "Ubicaciones de ${superhero.name}: ${superhero.locations}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
