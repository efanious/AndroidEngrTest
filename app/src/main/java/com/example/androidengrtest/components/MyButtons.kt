package com.example.androidengrtest.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyButton(buttonText: String, onButtonClicked: () -> Unit = {}) {
    Button(
        modifier = Modifier.width(180.dp),
        onClick = onButtonClicked,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
        border = BorderStroke(
            1.dp,
            color = Color.Black
        )
    ) {
        Text(
            text = buttonText,
            color = Color.White
        )
    }
}
