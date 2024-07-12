package com.example.androidengrtest.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidengrtest.R
import com.example.androidengrtest.ui.theme.LightGreen
import com.example.androidengrtest.ui.theme.manropeFamily

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UserCardItem(
    onUserCardClicked: () -> Unit = {}
) {
    Card(shape = RoundedCornerShape(6.dp), onClick = onUserCardClicked) {
        Column(
            modifier = Modifier
                .height(118.dp)
                .width(156.dp)
                .background(LightGreen)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {

                Spacer(modifier = Modifier.width(12.dp))
                Image(
                    painter = painterResource(id = R.drawable.users_dash_ic),
                    contentDescription = "user",
                    Modifier
                        .size(35.dp)
                        .clip(RoundedCornerShape(2.dp))
                )
            }

            Spacer(modifier = Modifier.height(41.dp))

            Row {
                Spacer(modifier = Modifier.width(14.dp))

                Text(
                    text = "Users",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = manropeFamily, fontWeight = FontWeight.Bold
                )
            }

        }
    }
}
