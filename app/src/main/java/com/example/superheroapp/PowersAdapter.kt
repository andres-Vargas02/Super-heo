package com.example.superheroapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.data.models.Power

class PowersAdapter(
    private val powers: List<Power>
) : RecyclerView.Adapter<PowersAdapter.PowerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PowerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_power, parent, false)
        return PowerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PowerViewHolder, position: Int) {
        val power = powers[position]
        holder.bind(power)
    }

    override fun getItemCount(): Int = powers.size

    inner class PowerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val powerName: TextView = itemView.findViewById(R.id.tvPowerName)

        fun bind(power: Power) {
            powerName.text = power.name
        }
    }
}
