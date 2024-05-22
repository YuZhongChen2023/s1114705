package com.example.s1114705

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.s1114705.ui.theme.S1114705Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S1114705Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Greeting(
                        FirstScreen()
                }
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavController){
    val context = LocalContext.current  //取得App的運行環境
    var url by remember { mutableStateOf("https://www.pu.edu.tw") }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )

    {
        Button(onClick = {
            var it = Intent(context, SecondActivity::class.java)
            it.putExtra("website", "https://www.pu.edu.tw")
            context.startActivity(it)
        })

        {
            Text(text = "跳轉到SecondActivity")
        }
        Button(
            onClick = {
                var it = Intent(Intent.ACTION_SENDTO)
                it.data = Uri.parse("mailto:tcyang@gm.pu.edu.tw")
                context.startActivity(it)
            }
        )
        {
            Text(text = "寄發電子郵件")
        }
        Button(
            onClick = {
                var it = Intent(Intent.ACTION_SENDTO)
                it.data = Uri.parse("mailto:tcyang@gm.pu.edu.tw")
                context.startActivity(it)
            }
        )
        {
            Text(text = "寄發電子郵件")
        }
        Button(
            onClick = {
                var it = Intent(Intent.ACTION_WEB_SEARCH)
                it.putExtra(SearchManager.QUERY, "靜宜資管")
                context.startActivity(it)
            }
        )
        {
            Text(text = "搜尋關鍵字")
        }
        Button(
            onClick = {
                var it = Intent(Intent.ACTION_VIEW)
                it.data = Uri.parse("geo:24.2267756,120.5771591")
                context.startActivity(it)
            }
        )
        {
            Text(text = "Google Map查詢")
        }

    }
}

@Composable
fun SecondScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Yellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {

        }) {
            Text(text = "我是畫面2，按一下跳至畫面1")
        }

    }
}

@Composable
fun Main() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "JumpFirst"){
        composable("JumpFirst"){
            FirstScreen(navController = navController)
        }
        composable("JumpSecond"){
            SecondScreen(navController = navController)
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "簡介",
        color = Color.Blue,
        modifier = modifier
    )
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Main() {
        val navController = rememberNavController()
        val context = LocalContext.current
        var showMenu by remember { mutableStateOf(false) }

        Column {
            TopAppBar(
                title = { Text(text = "頁面轉換實例") },
                navigationIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, "您點選了導覽圖示", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(Icons.Default.Menu, contentDescription = "Navigation icon")
                    }
                },
                actions = {
                    IconButton(
                        onClick = { Toast.makeText(context, "作者：陳昱中", Toast.LENGTH_SHORT).show() }
                    ) {
                        Icon(Icons.Rounded.AccountBox, contentDescription = "Author")
                    }
                    IconButton(
                        onClick = { showMenu = true }
                    ) {
                        Icon(Icons.Default.MoreVert, contentDescription = "More")
                    }

                }

            )

            NavHost(navController = navController, startDestination = "JumpFirst") {
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    S1114705Theme {
        Greeting("Android")
    }
}