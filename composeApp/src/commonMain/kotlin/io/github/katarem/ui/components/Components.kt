package io.github.katarem.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.kodein.emoji.Emoji
import org.kodein.emoji.EmojiFinder
import org.kodein.emoji.animals_nature.animal_bird.Goose

@Composable
fun TopBar(){
    Row(modifier = Modifier.fillMaxWidth().background(color = Color.Blue).padding(10.dp)) {
        val emoji = Emoji.Goose
        Text(
            text = "Commit It Now! $emoji",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

@Composable
fun BottomBar(){
    Row(
        modifier = Modifier.fillMaxWidth().background(color = Color.Blue).padding(10.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = null,
            modifier = Modifier.weight(1f),
            tint = Color.White
        )
        Icon(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = null,
            modifier = Modifier.weight(1f),
            tint = Color.White
        )
        Icon(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = null,
            modifier = Modifier.weight(1f),
            tint = Color.White
        )

    }
}