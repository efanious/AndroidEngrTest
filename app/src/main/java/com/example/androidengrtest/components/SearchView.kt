package com.example.androidengrtest.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun SearchView(
    search: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp, 8.dp, 8.dp, 8.dp))
            .background(color = Color.White)

    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextField(value = search,
                modifier = Modifier.width(200.dp),
                onValueChange = onValueChange,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    placeholderColor = Color(0XFF888D91),
                    leadingIconColor = Color(0XFF888D91),
                    trailingIconColor = Color(0XFF888D91),
                    textColor = Color.DarkGray,
                    focusedIndicatorColor = Color.Transparent, cursorColor = Color(0XFF070E14)
                ),
                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
                //trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
                placeholder = { Text(text = "Search") }
            )


        }


    }

}
