package com.example.androidengrtest.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidengrtest.common.data.api.models.RepositoryItem
import com.example.androidengrtest.ui.theme.manropeFamily


@Composable
fun RepositoryItemCard(
    repositoryItem: RepositoryItem
) {
    Card(shape = MaterialTheme.shapes.large) {
        Column(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    bottom = 8.dp
                ).height(90.dp)
                .fillMaxWidth()
        ) {
            repositoryItem.owner?.avatarUrl?.let { repositoryItem.fullName?.let { it1 ->
                Header(it,
                    it1
                )
            } }
            Spacer(modifier = Modifier.height(12.dp))

            repositoryItem.description?.let {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp, end = 12.dp),
                    text = it,
                    fontSize = 12.sp,
                    //fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    fontFamily = manropeFamily, fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Composable
fun Header(image: String, title: String
) {
    Row(
        modifier = Modifier.padding(start = 12.dp, end = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularImageContent(image)
        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = title,
            color = Color.Black,
            fontSize = 16.sp,
            fontFamily = manropeFamily, fontWeight = FontWeight.Bold,
            maxLines = 1
        )

    }

}
