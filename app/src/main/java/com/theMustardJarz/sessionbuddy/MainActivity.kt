package com.theMustardJarz.sessionbuddy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.theMustardJarz.sessionbuddy.ui.theme.SessionBuddyTheme

class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()
        setContent {
            SessionBuddyTheme {
                Scaffold(
                    content = {
                        Modifier.padding(it)
                        MyComposable()
                        GreetingPreview()
                    }
                )
            }
        }
    }

    @Preview(showBackground = true)
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyComposable() {
        var counter by remember { mutableIntStateOf(0) }

        Scaffold(
            topBar = {
                TopAppBar(title = { Text("My App") })
            },
            content = { innerPadding ->
                Button(onClick = { counter++ }, modifier = Modifier.padding(innerPadding)) {
                    Text("Counter: $counter")
                }
            }
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        SessionBuddyTheme {
            Greeting("Max")
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}

