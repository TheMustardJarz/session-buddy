package com.theMustardJarz.sessionbuddy

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.theMustardJarz.sessionbuddy.ui.theme.SessionBuddyTheme


class MainActivity : AppCompatActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SessionBuddyTheme {
                SessionPointComp()
            }
        }
    }

    @ExperimentalMaterial3Api
    @Composable
    fun SessionPointComp() {
        var timesClicked by remember { mutableIntStateOf(0) }

        Scaffold(
            content = { innerPadding ->
                Column(Modifier.padding(innerPadding)) {
                    Button(onClick = { timesClicked++ }) {
                        Text("Click Me!")
                    }
                    Text(
                        text = "You have clicked the button $timesClicked times.",
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        )
    }

    @ExperimentalMaterial3Api
    @Composable
    fun MyComposable() {
        var counter by remember { mutableIntStateOf(0) }

        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.primaryContainer
                    ),
                    title = {
                        Text("Session Tasks")
                    }
                )
            },
            content = { innerPadding ->
                Button(
                    onClick = { counter++ },
                    modifier = Modifier.padding(innerPadding),
                    content = {
                        Text("Click Me!")
                    }
                )
                Text(
                    text = "You have clicked the button $counter times.",
                    modifier = Modifier.padding(innerPadding),
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize
                )
            }
        )
    }
}

