package com.example.ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.ejercicio1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun click(view: View) {
        var parametros = Bundle()

        with(binding) {
            when {
                tietNombre.text.toString().isEmpty() -> {
                    tietNombre.error = "No puede quedar vacío"
                    Toast.makeText(
                        this@MainActivity,
                        "Por favor llene todos los campos",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                tietNacimiento.text.toString().isEmpty() -> {
                    tietNacimiento.error = "No puede quedar vacío"
                    Toast.makeText(
                        this@MainActivity,
                        "Por favor llene todos los campos",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                tietNumCuenta.text.toString().isEmpty() -> {
                    tietNumCuenta.error = "No puede quedar vacío"
                    Toast.makeText(
                        this@MainActivity,
                        "Por favor llene todos los campos",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                tietCorreo.text.toString().isEmpty() -> {
                    tietCorreo.error = "No puede quedar vacío"
                    Toast.makeText(
                        this@MainActivity,
                        "Por favor llene todos los campos",
                        Toast.LENGTH_SHORT
                    ).show()
                }else -> {
                    if(true){
                        //Toast.makeText(this@MainActivity,"Gracias",Toast.LENGTH_SHORT).show()
                        parametros.apply{
                            putString("nombre", tietNombre.text.toString())
                            putString("fecha",tietNacimiento.text.toString())
                            putString("numeroCuenta",tietNumCuenta.text.toString())
                            putString("correo",tietCorreo.text.toString())
                        }

                        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                        intent.putExtras(parametros)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(
                            this@MainActivity,
                            "Error al actualizar el registro",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
            }
        }
    }
}