package com.example.ejercicio1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ejercicio1.databinding.ActivityDetailsBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.concurrent.TimeUnit
import kotlin.math.floor

@Suppress("DEPRECATION")
class DetailsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailsBinding
    var edad = ""

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        val nombre = bundle?.getString("nombre","byDefault")
        val fechaNacimientoString = bundle?.getString("fecha","byDefault")
        val numeroCuenta = bundle?.getString("numeroCuenta","byDefault")
        val email = bundle?.getString("correo","byDefault")

        val fechaNacimientoDate:Date = SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimientoString.toString()) as Date
        val calendario = Calendar.getInstance()
        calendario.time = fechaNacimientoDate

        calcularEdad(fechaNacimientoDate)

        val anio = calendario.get(Calendar.YEAR)
        Log.d("anio",anio.toString() )

        setSignoChino(anio)

        //TODO
        setSignoZodiacal()

        with(binding){
            tvNombre.text = nombre
            tvEdad.text = edad
            tvFechaNacimiento.text = fechaNacimientoString.toString()
            tvNumeroCuenta.text = numeroCuenta
            tvCorreoElectronico.text = email
        }
    }

    private fun calcularEdad(fechaNacimiento: Date){
        val fechaActual = Date(System.currentTimeMillis())
        val diferenciaEntreFechas = fechaActual.time - fechaNacimiento.time

        val segundos = (diferenciaEntreFechas/1000).toFloat()
        val minutos = segundos/60
        val horas = minutos/60
        val dias = horas/24
        val anios = dias/365

        edad = floor(anios).toInt().toString()
    }

    private fun setSignoChino(anio_de_nacimiento:Int) {
        val origen = 1900
        val distancia = obtener_distancia_desde_origen(anio_de_nacimiento,origen)
        val columna = obtener_columna(distancia)
        val base_de_columna = columna * 12
        val fila = distancia - base_de_columna
        Log.d("Salida","La fila es " + fila.toString())

        when(fila){
            0 -> binding.ivSignoChino.setImageResource(R.drawable.chino_rata)
            1 -> binding.ivSignoChino.setImageResource(R.drawable.chino_buey)
            2 -> binding.ivSignoChino.setImageResource(R.drawable.chino_tigre)
            3 -> binding.ivSignoChino.setImageResource(R.drawable.chino_conejo)
            4 -> binding.ivSignoChino.setImageResource(R.drawable.chino_dragon)
            5 -> binding.ivSignoChino.setImageResource(R.drawable.chino_serpiente)
            6 -> binding.ivSignoChino.setImageResource(R.drawable.chino_caballo)
            7 -> binding.ivSignoChino.setImageResource(R.drawable.chino_cabra)
            8 -> binding.ivSignoChino.setImageResource(R.drawable.chino_mono)
            9 -> binding.ivSignoChino.setImageResource(R.drawable.chino_gallo)
            10 -> binding.ivSignoChino.setImageResource(R.drawable.chino_perro)
            11 -> binding.ivSignoChino.setImageResource(R.drawable.chino_cerdo)
        }
    }

    private fun setSignoZodiacal() {

    }

    private fun obtener_distancia_desde_origen(anio_de_nacimiento:Int,origen:Int): Int {
        return anio_de_nacimiento - origen
    }
    private fun obtener_columna(distancia:Int):Int{
        val base_num = 12
        return floor((distancia/base_num).toDouble()).toInt()
    }



    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
    }
}