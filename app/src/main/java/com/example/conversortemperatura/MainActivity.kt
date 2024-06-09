package com.example.conversortemperatura

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.example.conversortemperatura.ui.theme.ConversorTemperaturaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConversorTemperaturaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val celsios = remember { mutableStateOf("") }
    val fahrenheit = remember { mutableStateOf("") }
    val resultadoCelsios = remember { mutableStateOf("") }
    val resultadoFahrenheit = remember { mutableStateOf("") }

    fun celsiosParaFahrenheit() {
        if (celsios.value.isNotEmpty()) {
            val result = String.format("%.2f", (celsios.value.toDouble() * 1.8 + 32))
            resultadoCelsios.value = "${celsios.value}°C -> ${result}°F"
        }
    }

    fun fahrenheitParaCelsios() {
        if (fahrenheit.value.isNotEmpty()) {
            val result = String.format("%.2f", ((fahrenheit.value.toDouble() - 32) / 1.8))
            resultadoFahrenheit.value = "${fahrenheit.value}°F -> ${result}°C"
        }
    }

    Column {
        Row {
            Text(
                text = "Conversor de Temperatura",
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp)
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row {
            OutlinedTextField(
                value = celsios.value,
                label = { Text("Celsios") },
                onValueChange = { if (it.isDigitsOnly()) celsios.value = it },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }
        Row {
            OutlinedTextField(
                value = fahrenheit.value,
                label = { Text("Fahrenheit") },
                onValueChange = { if (it.isDigitsOnly()) fahrenheit.value = it },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Button(
                onClick = { celsiosParaFahrenheit(); fahrenheitParaCelsios() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Converter")
            }
        }
        Spacer(modifier = Modifier.height(60.dp))
        Row {
            Text(
                resultadoCelsios.value,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Text(
                resultadoFahrenheit.value,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
