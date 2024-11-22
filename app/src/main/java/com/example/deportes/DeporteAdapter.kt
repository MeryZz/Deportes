package com.example.deportes;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class DeporteAdapter(private val deportes: List<Deporte>) : RecyclerView.Adapter<DeporteAdapter.DeporteViewHolder>() {

    inner class DeporteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkDeporte: CheckBox = itemView.findViewById(R.id.checkDeporte)
        val iconDeporte: ImageView = itemView.findViewById(R.id.iconDeporte)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeporteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_deporte, parent, false)
        return DeporteViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeporteViewHolder, position: Int) {
        val deporte = deportes[position]
        holder.checkDeporte.text = deporte.nombre
        holder.iconDeporte.setImageResource(deporte.icono)
        holder.checkDeporte.isChecked = deporte.seleccionado

        holder.checkDeporte.setOnCheckedChangeListener { _, isChecked ->
            deporte.seleccionado = isChecked
        }
    }

    override fun getItemCount(): Int = deportes.size
}