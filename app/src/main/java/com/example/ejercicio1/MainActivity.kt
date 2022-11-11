package com.example.ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click(view: View) {
        //Manejamos el click del elemento en el recycler view
        val intent = Intent(this,DetailsActivity::class.java )
        //intent.putExtra("ID",movie.id)
        startActivity(intent)
        finish()
    }
}