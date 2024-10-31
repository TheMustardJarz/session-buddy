@file:OptIn(ExperimentalMaterial3Api::class)

package com.theMustardJarz.sessionbuddy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.theMustardJarz.sessionbuddy.ui.theme.SessionBuddyTheme
import com.theMustardJarz.sessionbuddy.utilityClasses.SessionTask

/**
 * The screen which manages the tasks needed to complete for the session. You will create a task, or
 * a plot point, through the button at the top-right of the screen. This button allows you to add a
 * new task to the list. You will be able to set the text of the task.
 *
 * You will be able to create subtasks through the hamburger menu on the right side of any given
 * task. You will be able to set the text of the subtask as you would be able to with a task.
 *
 * @property title The title of the session.
 *
 * @author Maxwell Collins
 */
class SessionActivity() : AppCompatActivity() {

    constructor(title: String) : this() {
        this.title = title
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SessionBuddyTheme {
                SessionTasks()
            }
        }
    }

    @Composable
    fun SessionTasks() {
        var tasks = remember { mutableStateListOf<SessionTask>() }

        Scaffold (
            content = { innerPadding ->
                Column(Modifier.padding(innerPadding)) {
                    OutlinedButton(onClick = { createNewTask("New Task", tasks) }) {
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

    /**
     * Creates a new task with the given text, then adds it to the given list.
     *
     * @param task The text of the task to create.
     *
     * @param taskList The list to add the new task to.
     */
    fun createNewTask(task: String, taskList: MutableList<SessionTask>) {
        taskList.add(SessionTask(task))
    }
}