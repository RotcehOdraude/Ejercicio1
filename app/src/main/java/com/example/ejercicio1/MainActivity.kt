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
    var parametros = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun click(view: View) {
        var bandera = true
        fun alert() {
            bandera = false
            /*Toast.makeText(
                this@MainActivity,
                "Por favor llene todos los campos",
                Toast.LENGTH_SHORT
            ).show()*/
        }
        with(binding) {
            if (tietNombre.text?.isEmpty() == true) {
                tietNombre.error = getString(R.string.et_error_msg)
                alert()
            }
            if (tietApellidos.text?.isEmpty() == true) {
                tietApellidos.error = getString(R.string.et_error_msg)
                alert()
            }
            if (tietNacimiento.text?.isEmpty() == true) {
                tietNacimiento.error = getString(R.string.et_error_msg)
                alert()
            }
            if (tietNumCuenta.text?.isEmpty() == true) {
                tietNumCuenta.error = getString(R.string.et_error_msg)
                alert()
            }
            if (tietCorreo.text?.isEmpty() == true) {
                tietCorreo.error = getString(R.string.et_error_msg)
                alert()
            }

            if(bandera == true) {
                //Toast.makeText(this@MainActivity,"Gracias",Toast.LENGTH_SHORT).show()
                parametros.apply {
                    putString("nombre", tietNombre.text.toString())
                    putString("fecha", tietNacimiento.text.toString())
                    putString("numeroCuenta", tietNumCuenta.text.toString())
                    putString("correo", tietCorreo.text.toString())
                }
                val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                intent.putExtras(parametros)
                startActivity(intent)
                finish()
            }

        }
    }
}