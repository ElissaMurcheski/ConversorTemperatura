package com.example.conversortemperatura

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.conversortemperatura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonConverterFahrenheit.setOnClickListener{
            if (!binding.editTemperatura.text.toString().isEmpty()) {
                val celsius = binding.editTemperatura.text.toString().toDouble()
                val fahrenheit = String.format("%.2f", celsius * 1.8 + 32)

                binding.textResultado.text = "$fahrenheit °F"

            }else{
                binding.textResultado.text = "Temperatura inválida"
            }
        }

        binding.buttonConverterCelsius.setOnClickListener{
            if (!binding.editTemperatura.text.toString().isEmpty()) {
                val fahrenheit = binding.editTemperatura.text.toString().toDouble()
                val celsius = String.format("%.2f", (fahrenheit - 32) / 1.8)

                binding.textResultado.text = "$celsius °C"

            }else{
                binding.textResultado.text = "Temperatura inválida"
            }
        }
    }
}