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
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        val mes = calendario.get(Calendar.MONTH) + 1

        setSignoChino(anio)

        //TODO
        setSignoZodiacal(dia,mes)

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

        when(fila){
            0 -> {
                binding.ivSignoChino.setImageResource(R.drawable.chino_rata)
                binding.tvChinoHoroscopo.setText("Rata")
            }
            1 -> {
                binding.ivSignoChino.setImageResource(R.drawable.chino_buey)
                binding.tvChinoHoroscopo.setText("Buey")
            }
            2 -> {
                binding.ivSignoChino.setImageResource(R.drawable.chino_tigre)
                binding.tvChinoHoroscopo.setText("Tigre")
            }
            3 -> {
                binding.ivSignoChino.setImageResource(R.drawable.chino_conejo)
                binding.tvChinoHoroscopo.setText("Conejo")
            }
            4 -> {
                binding.ivSignoChino.setImageResource(R.drawable.chino_dragon)
                binding.tvChinoHoroscopo.setText("Dragon")
            }
            5 -> {
                binding.ivSignoChino.setImageResource(R.drawable.chino_serpiente)
                binding.tvChinoHoroscopo.setText("Serpiente")
            }
            6 -> {
                binding.ivSignoChino.setImageResource(R.drawable.chino_caballo)
                binding.tvChinoHoroscopo.setText("Caballo")
            }
            7 -> {
                binding.ivSignoChino.setImageResource(R.drawable.chino_cabra)
                binding.tvChinoHoroscopo.setText("Cabra")
            }
            8 -> {
                binding.ivSignoChino.setImageResource(R.drawable.chino_mono)
                binding.tvChinoHoroscopo.setText("Mono")
            }
            9 -> {
                binding.ivSignoChino.setImageResource(R.drawable.chino_gallo)
                binding.tvChinoHoroscopo.setText("Gallo")
            }
            10 -> {
                binding.ivSignoChino.setImageResource(R.drawable.chino_perro)
                binding.tvChinoHoroscopo.setText("Perro")
            }
            11 -> {
                binding.ivSignoChino.setImageResource(R.drawable.chino_cerdo)
                binding.tvChinoHoroscopo.setText("default")
            }
        }
    }

    private fun setSignoZodiacal(dia: Int, mes: Int) {
        Log.d("Salida","Los datos son:" + dia.toString() + "," + mes.toString())
        when {
            (mes == 1 && dia >= 20 || mes == 2 && dia <= 19) -> {
                binding.tvZodiacalSigno.text = "Acuario"
                binding.ivSignoZodiacal.setImageResource(R.drawable.zodiaco_acuario)
            }
            (mes == 2 && dia >= 20 || mes == 3 && dia <= 20) -> {
                binding.tvZodiacalSigno.text = "Picis"
                binding.ivSignoZodiacal.setImageResource(R.drawable.zodiaco_piscis)
            }
            (mes == 12 && dia >= 22 || mes == 1 && dia <= 19) -> {
                binding.tvZodiacalSigno.text = "Capricornio"
                binding.ivSignoZodiacal.setImageResource(R.drawable.zodiaco_capricornio)
            }
            (mes == 11 && dia >= 23 || mes == 12 && dia <= 21) -> {
                binding.tvZodiacalSigno.text = "Sagitario"
                binding.ivSignoZodiacal.setImageResource(R.drawable.zodiaco_sagitario)
            }
            (mes == 10 && dia >= 23 || mes == 11 && dia <= 22) -> {
                binding.tvZodiacalSigno.text = "Escorpion"
                binding.ivSignoZodiacal.setImageResource(R.drawable.zodiaco_escorpion)
            }
            (mes == 9 && dia >= 23 || mes == 10 && dia <= 22) -> {
                binding.tvZodiacalSigno.text = "Libra"
                binding.ivSignoZodiacal.setImageResource(R.drawable.zodiaco_libra)
            }
            (mes == 8 && dia >= 23 || mes == 9 && dia <= 22) -> {
                binding.tvZodiacalSigno.text = "Virgo"
                binding.ivSignoZodiacal.setImageResource(R.drawable.zodiaco_virgo)
            }
            (mes == 7 && dia >= 23 || mes == 8 && dia <= 22) -> {
                binding.tvZodiacalSigno.text = "Leo"
                binding.ivSignoZodiacal.setImageResource(R.drawable.zodiaco_leo)
            }
            (mes == 6 && dia >= 21 || mes == 7 && dia <= 22) -> {
                binding.tvZodiacalSigno.text = "Cancer"
                binding.ivSignoZodiacal.setImageResource(R.drawable.zodiaco_cancer)
            }
            (mes == 5 && dia >= 21 || mes == 6 && dia <= 20) -> {
                binding.tvZodiacalSigno.text = "Geminis"
                binding.ivSignoZodiacal.setImageResource(R.drawable.zodiaco_geminis)
            }
            (mes == 4 && dia >= 21 || mes == 5 && dia <= 20) -> {
                binding.tvZodiacalSigno.text = "Taurus"
                binding.ivSignoZodiacal.setImageResource(R.drawable.zodiaco_tauro)
            }
            (mes == 3 && dia >= 21 || mes == 4 && dia <= 20) -> {
                binding.tvZodiacalSigno.text = "Aries"
                binding.ivSignoZodiacal.setImageResource(R.drawable.zodiaco_aries)
            }
            else -> "Input invalido"
        }
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