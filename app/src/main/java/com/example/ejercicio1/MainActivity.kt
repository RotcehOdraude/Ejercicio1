package com.example.ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.ejercicio1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var parametros = Bundle()
    var spinnerPosition = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.carreras,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding.spinnerCarreras.adapter = adapter
        }

        binding.spinnerCarreras.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Log.d("LOGTAG", "El item seleccionado tiene la posición $position")
                    spinnerPosition = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
    }

    private fun isValidEmail(mail: CharSequence) = (!TextUtils.isEmpty(mail) && Patterns.EMAIL_ADDRESS.matcher(mail).matches())

    fun click(view: View) {
        var bandera = true
        fun alert(msg: String, display: Boolean = false) {
            bandera = false
            if(display) {
                Toast.makeText(
                    this@MainActivity,
                    msg,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val error_msg = getString(R.string.et_error_msg)
        with(binding) {
            if (tietNombre.text?.isEmpty() == true) {
                tietNombre.error = error_msg
                alert("")
            }
            if (tietApellidos.text?.isEmpty() == true) {
                tietApellidos.error = error_msg
                alert("")
            }
            if (tietNacimiento.text?.isEmpty() == true) {
                tietNacimiento.error = error_msg
                alert("")
            }
            if (tietNumCuenta.text?.isEmpty() == true) {
                tietNumCuenta.error = error_msg
                alert("")
            }
            if (tietCorreo.text?.isEmpty() == true || !isValidEmail(tietCorreo.text.toString())) {
                tietCorreo.error = error_msg
                alert("Correo invalido",true)
            }
            if (spinnerPosition == 0) {
                alert(getString(R.string.spinner_error_msg),true)
            }

            if (bandera == true) {
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