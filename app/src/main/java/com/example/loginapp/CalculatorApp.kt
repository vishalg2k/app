package com.example.loginapp

import android.graphics.drawable.PaintDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginapp.ui.theme.LoginAppTheme

class CalculatorApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting2( modifier: Modifier = Modifier) {
    var s1 by remember {
        mutableStateOf("")
    }
    var s2 by remember {
        mutableStateOf("")
    }
    var res by remember {
        mutableStateOf("")
    }
    var b by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(painterResource(id = R.drawable.bg),
            contentScale = ContentScale.FillBounds),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp).background(color = Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Calculator App",
                color = Color.Gray,
                fontSize = 32.sp,
                modifier = Modifier.padding(12.dp)
            )

            TextField(
                value = s1,
                onValueChange = { s1 = it },
                label = { Text(text = "Enter 1st value") }
            )
            TextField(
                value = s2,
                onValueChange = { s2 = it },
                label = { Text(text = "Enter 2nd value") }
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Button(onClick = {
                    b = true
                    res = (s1.toInt() + s2.toInt()).toString()
                }) {
                    Text(text = "Add")
                }
                Button(onClick = {
                    b = true
                    res = (s1.toInt() - s2.toInt()).toString()
                }) {
                    Text(text = "Sub")
                }
                Button(onClick = {
                    b = true
                    res = (s1.toInt() * s2.toInt()).toString()
                }) {
                    Text(text = "Multiply")
                }
                Button(onClick = {
                    b = true
                    res = (s1.toDouble() / s2.toDouble()).toString()
                }) {
                    Text(text = "Divide")
                }
            }
            if (b) {
                Text(text = "Result is : $res", color = Color.Red, fontSize = 22.sp)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    LoginAppTheme {
        Greeting2()
    }
}