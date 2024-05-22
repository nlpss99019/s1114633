package com.example.s1114633

import android.annotation.SuppressLint
import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.s1114633.ui.theme.S1114633Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.foundation.layout.Column

import androidx.compose.material3.Button
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource



class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S1114633Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Greeting()
                    Main()
                }
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavHostController) {
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
    )
    {
        Text(text = "瑪利亞基金會服務總覽",
            fontSize = 15.sp,
            color = Color.Blue)
        Image(
            painter = painterResource(id = R.drawable.service),
            contentDescription = "圖片",
            alpha = 0.7f,
            modifier = Modifier
        )
        Button(onClick = {
            navController.navigate("JumpSecond")
        }) {
            Text(text = "作者：資管二B王梓芸")
        }
    }
}
@Composable
fun SecondScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
    ) {

        Text(text = "APP作者",
            fontSize = 15.sp,
            color = Color.Blue
        )
        Image(
            painter = painterResource(id = R.drawable.a),
            contentDescription = "圖片",
            alpha = 0.7f,
            modifier = Modifier
        )
        Button(onClick = {
            navController.navigate("JumpFirst")
        }) {
            Text(text = "服務總覽")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main() {
    val navController = rememberNavController()
    var showMenu by remember {mutableStateOf(false) }

    Column{
        TopAppBar(
            title = { Text(text = "頁面轉換實例") },

            actions = {
                IconButton(
                    onClick = { showMenu = true }
                ) {
                    Icon(Icons.Default.MoreVert, contentDescription = "More")
                }
                DropdownMenu(
                    expanded = showMenu, onDismissRequest = { showMenu = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("服務總覽") },
                        onClick = { navController.navigate("JumpFirst")})

                    DropdownMenuItem(
                        text = { Text("作者：資管二Bxxx") },
                        onClick = { navController.navigate("JumpSecond")})
                }


            }
        )
        NavHost(navController = navController, startDestination = "JumpFirst") {
            composable("JumpFirst") {
                FirstScreen(navController = navController)
            }

            composable("JumpSecond") {
                SecondScreen(navController = navController)
            }
        }
    }
}














