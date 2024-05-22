package com.example.s1114705

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.s1114705.ui.theme.S1114705Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S1114705Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current  //取得App的運行環境
    val activity = (context as Activity)  //取得App運行的活動
    var url:String? = context.intent.getStringExtra("website")

    Column {
        Text(
            text = "SecondAcyivity\n網址為：" + url!!

        )
        Button(
            onClick = {
                activity.finish()
            })
        {
            Text(text = "回到MainActivity")
        }
    }
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()

                settings.useWideViewPort = true
                settings.setSupportZoom(true)
            }
        },
        update = { webView ->
            webView.loadUrl(url!!)
        }
    )


    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    S1114705Theme {
        Greeting2("")
    }
}