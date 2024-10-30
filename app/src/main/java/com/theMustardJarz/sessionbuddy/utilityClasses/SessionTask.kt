package com.theMustardJarz.sessionbuddy.utilityClasses

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration

/**
 * Represents a task in a session. When a user clicks the checkbox, the task is marked as completed.
 *
 * @property task The description of the task.
 *
 * @author Maxwell Collins
 */
class SessionTask(val task: String) {

    /**
     * Creates a task in the session.
     */
    @Composable
    fun CreateTask() {
        var checked = remember { mutableStateOf(false) }

        Scaffold(
            content = { innerPadding ->
                Row(Modifier.padding(innerPadding)) {
                    Checkbox(
                        checked = checked.value,
                        onCheckedChange = {
                            checked.value = it
                        }
                    )
                    Text(
                        text = task,
                        style = TextStyle(
                            textDecoration = if (checked.value) TextDecoration.LineThrough else TextDecoration.None
                        ),
                        color = if (checked.value) Color.Gray else Color.Black
                    )
                }
            }
        )
    }
}
