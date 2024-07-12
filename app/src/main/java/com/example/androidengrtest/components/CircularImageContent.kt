package com.example.androidengrtest.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun CircularImageContent(imagePath: String) {

    AsyncImage(
        model = imagePath,
        contentDescription = null,
        modifier = Modifier
            .width(20.dp)
            .height(20.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )

}
