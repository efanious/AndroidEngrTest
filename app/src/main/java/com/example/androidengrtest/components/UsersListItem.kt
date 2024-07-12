package com.example.androidengrtest.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidengrtest.common.data.api.models.UserItem


@Composable
fun UsersListItem(
    userItem: UserItem, onUserClick : (UserItem) -> Unit)
 {

    Card(shape = MaterialTheme.shapes.medium) {
        Column(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    bottom = 8.dp
                ).height(90.dp)
                .fillMaxWidth().clickable { onUserClick(userItem) }
        ) {
            userItem.avatarUrl?.let { userItem.login?.let { it1 -> Header(it, it1) } }
            Spacer(modifier = Modifier.height(6.dp))

        }
    }

}