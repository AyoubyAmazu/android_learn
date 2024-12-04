package com.example.tuto3_plus

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tuto3_plus.ui.theme.Tuto3_plusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InteractiveButtonsApp(this)
        }
    }
}
    @Composable
    fun InteractiveButtonsApp(activity : Activity) {
        MaterialTheme {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    OpenWebsiteButton(activity)
                    SendEmailButton(activity)
                    DialPhoneNumberButton(activity)
                }
            }
        }
    }

    @Composable
    fun OpenWebsiteButton(activity : Activity) {
        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            activity.startActivity(intent)
        }) {
            Text("Ouvrir un site web")
        }
    }

    @Composable
    fun SendEmailButton(activity : Activity) {
        Button(onClick = {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:test@example.com")
                putExtra(Intent.EXTRA_SUBJECT, "Sujet de l'email")
            }
            activity.startActivity(intent)
        }) {
            Text("Envoyer un email")
        }
    }

    @Composable
    fun DialPhoneNumberButton(activity : Activity) {
        Button(onClick = {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+123456789"))
            activity.startActivity(intent)
        }) {
            Text("Appeler un numéro")
        }
    }
