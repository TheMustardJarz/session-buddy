package com.theMustardJarz.sessionbuddy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class SessionCreationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateTask()
        }
    }

    @Composable
    fun CreateTask() {
        val body = remember { mutableStateOf("Hello") }

        TextField(
            value = body.value,
            onValueChange = { body.value = it },
            label = @Composable {
                Text(text = "Task")
            }
        )
    }
}