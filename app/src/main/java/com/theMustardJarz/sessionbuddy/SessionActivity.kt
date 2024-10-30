@file:OptIn(ExperimentalMaterial3Api::class)

package com.theMustardJarz.sessionbuddy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.theMustardJarz.sessionbuddy.ui.theme.SessionBuddyTheme
import com.theMustardJarz.sessionbuddy.utilityClasses.SessionTask

class SessionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SessionBuddyTheme {
                SessionTasks()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun SessionTasks() {
        var tasks = remember { mutableStateListOf<SessionTask>() }

        Scaffold (
            content = { innerPadding ->
                Column(Modifier.padding(innerPadding)) {
                    Button(onClick = { tasks.add(SessionTask("New Task")) }) {
                        Text("Add Task")
                    }
                    Text("Tasks")
                    Column {
                        tasks.forEach { task ->
                            task.CreateTask()
                        }
                    }
                }
            }
        )
    }
}