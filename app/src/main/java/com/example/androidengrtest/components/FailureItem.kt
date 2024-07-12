package com.example.androidengrtest.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androidengrtest.R
import com.example.androidengrtest.ui.theme.manropeFamily


@Composable
fun FailureItem(
    message: String
) {

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(
            top = 100.dp,
            bottom = 8.dp
        )
    ) {
        Image(
            painter = painterResource(id = R.drawable.search_error_ic),
            contentDescription = "Error image",
            modifier = Modifier
                .size(72.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = message,
            color = Color.Black,
            fontFamily = manropeFamily, fontWeight = FontWeight.Light,
            modifier = Modifier.padding(start = 30.dp, end = 30.dp),
            textAlign = TextAlign.Center
        )
    }

}

