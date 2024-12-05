package com.example.tuto4

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tuto4.ui.theme.Tuto4Theme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tuto4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
              InteractiveForm()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun InteractiveButton() {
    var count by remember { mutableStateOf(0) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Clics : $count")
        Button(onClick = { count++ }) {
            Text("Cliquez-moi")
        }
    }
}
@Composable
fun InteractiveForm() {
    var name by remember { mutableStateOf("") }
    var isSubscribed by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }

    Column {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Votre nom") })
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = isSubscribed, onCheckedChange = { isSubscribed = it })
            Text("Recevoir des notifications")
        }
        Button(onClick = {
            message = if (isSubscribed) "Bienvenue, $name !" else "Merci $name, cochez pour des notifications."
        }) {
            Text("Valider")
        }
        if (message.isNotEmpty()) {
            Text(message)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tuto4Theme {
        Greeting("Android")
    }
}