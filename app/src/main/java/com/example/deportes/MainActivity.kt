package com.example.deportes

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton



class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton

    private val deportes = listOf(
        Deporte("Baloncesto", R.drawable.baloncesto),
        Deporte("Béisbol", R.drawable.beisbol),
        Deporte("Ciclismo", R.drawable.ciclismo),
        Deporte("Fútbol", R.drawable.futbol),
        Deporte("Golf", R.drawable.golf),
        Deporte("Hipica", R.drawable.hipica),
        Deporte("Natación", R.drawable.natacion),
        Deporte("Pinpon", R.drawable.pinpon),
        Deporte("Tenis", R.drawable.tenis)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        window.statusBarColor = ContextCompat.getColor(this, R.color.verdeO)


        recyclerView = findViewById(R.id.recyclerView)
        fab = findViewById(R.id.fab)

        val adapter = DeporteAdapter(deportes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        fab.setOnClickListener {
            val seleccionados = deportes.filter { it.seleccionado }.joinToString(", ") { it.nombre }
            val mensaje = if (seleccionados.isEmpty()) {
                "No has elegido ninguna opción"
            } else {
                "Has elegido $seleccionados"
            }
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }
    }


    // Inflar el menú
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Manejar la selección de opciones del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        when (id) {
            R.id.action_buscar -> {
                Toast.makeText(this, "Búsqueda", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_add -> {
                Toast.makeText(this, "Añadir", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_settings -> {
                Toast.makeText(this, "Ajustes", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}