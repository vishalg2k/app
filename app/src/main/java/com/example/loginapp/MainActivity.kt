package com.example.loginapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginapp.ui.theme.LoginAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppTheme {
                startActivity(Intent(applicationContext,CalculatorApp::class.java))
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(applicationContext)
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(applicationContext : Context){

    Column(modifier = Modifier
        .padding(12.dp)
        .fillMaxSize()
        .background(Color.Yellow),
        verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var s1 by remember {
            mutableStateOf("")
        }
        var s2 by remember {
            mutableStateOf("")
        }
        var b by remember {
            mutableStateOf(false)
        }

        Text(text = "Username", fontSize = 32.sp, color = Color.Cyan)
        TextField(value =s1 , onValueChange = {s1=it},
            label={ Text(text = "Username")})
        Text(text = "Password", fontSize = 32.sp, color = Color.Green)
        TextField(value =s2 , onValueChange = {s2=it},
            label={ Text(text = "password")})
        Row(
            modifier = Modifier.padding(20.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = {
                b=true
                Toast.makeText( applicationContext,
                    "pressed Sign Up",
                    Toast.LENGTH_LONG).show()

            }) {
                Text(text = "Sign Up")
            }
            Button(onClick = {
                Toast.makeText( applicationContext,
                    "pressed Sign In",
                    Toast.LENGTH_LONG).show()
            }) {
                Text(text = "Sign In")
            }
        }
        if(b){
            Text(text = s1, color = Color.Green)
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginAppTheme {
//        Greeting("Android")
//        LoginScreen(applicationContext = ap)
    }
}