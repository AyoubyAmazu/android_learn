package com.example.birthdaycart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycart.ui.theme.BirthdayCartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCartTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color.Blue
                ) {
                    GreetingText(
                        ville = "Tanger",
                        from = "Hercule, héros mythologique grec, est associé aux Grottes d'Hercule près de Tanger, où il aurait reposé après ses travaux. L'entrée des grottes, ressemblant à la forme de l'Afrique, renforce leur mystique. On raconte qu'il créa le détroit de Gibraltar en séparant l'Afrique de l'Europe.\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "\n",
                        modifier = Modifier

                    )

                }
            }
        }
    }
}

@Composable
fun GreetingText( ville:String,from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = ville,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Box (modifier.align(alignment = Alignment.CenterHorizontally),) {
            val image = painterResource(R.drawable.hercule)
            Image(
                painter = image,
                contentDescription = null,
                modifier = modifier



            )
       }
        Text(
            text = from,
            fontSize = 10.sp,
            modifier = Modifier
                    .padding(30.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )

    }

}
@Composable
fun GreetingImage(ville: String, from: String, modifier: Modifier = Modifier) {
        GreetingText(
            ville = ville,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }


@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    BirthdayCartTheme {
        GreetingText(ville="tanger",from = "Hercule, héros mythologique grec, est associé aux Grottes d'Hercule près de Tanger, où il aurait reposé après ses travaux. L'entrée des grottes, ressemblant à la forme de l'Afrique, renforce leur mystique. On raconte qu'il créa le détroit de Gibraltar en séparant l'Afrique de l'Europe.\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n",)
    }
}
