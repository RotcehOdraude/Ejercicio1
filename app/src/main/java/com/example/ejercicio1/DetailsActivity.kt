package com.example.ejercicio1

import android.app.appsearch.StorageInfo
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio1.databinding.ActivityDetailsBinding

@Suppress("DEPRECATION")
class DetailsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        var edad:String
        val nombre = bundle?.getString("nombre","byDefault")
        val fechaNacimiento = bundle?.getString("fecha","byDefault")
        val numeroCuenta = bundle?.getString("numeroCuenta","byDefault")
        val email = bundle?.getString("correo","byDefault")

        calcularEdad(fechaNacimiento)
        obtenerSignoChino()
        obtenerSignoZodiacal()

        with(binding){
            tvNombre.text = nombre
            tvEdad.text = "73"
            tvFechaNacimiento.text = fechaNacimiento
            tvNumeroCuenta.text = numeroCuenta
            tvCorreoElectronico.text = email
        }
    }

    private fun obtenerSignoZodiacal() {

    }

    private fun obtenerSignoChino() {

    }

    fun calcularEdad(fecha:String?){

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
    }
}