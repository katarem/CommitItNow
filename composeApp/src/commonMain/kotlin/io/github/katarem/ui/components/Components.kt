package io.github.katarem.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import commititnow.composeapp.generated.resources.Res
import commititnow.composeapp.generated.resources.clock
import commititnow.composeapp.generated.resources.history
import io.github.katarem.utils.PRIMARY_COLOR
import io.github.katarem.utils.SECONDARY_COLOR
import org.jetbrains.compose.resources.painterResource
import org.kodein.emoji.Emoji
import org.kodein.emoji.animals_nature.animal_bird.Goose

@Composable
fun TopBar(){
    Row(modifier = Modifier.fillMaxWidth().background(color = PRIMARY_COLOR).padding(10.dp)) {
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
        modifier = Modifier.fillMaxWidth().background(color = PRIMARY_COLOR).padding(10.dp)
    ) {
        Icon(
            painter = painterResource(Res.drawable.history),
            contentDescription = null,
            modifier = Modifier.weight(1f).height(30.dp),
            tint = Color.White
        )
        Icon(
            painter = painterResource(Res.drawable.clock),
            contentDescription = null,
            modifier = Modifier.weight(1f).height(30.dp),
            tint = Color.White
        )
        Icon(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = null,
            modifier = Modifier.weight(1f).height(30.dp),
            tint = Color.White
        )
    }
}


@Composable
fun MaterialTextButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    TextButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.textButtonColors(backgroundColor = PRIMARY_COLOR, contentColor = SECONDARY_COLOR),
        shape = RoundedCornerShape(25.dp)
    ){
        Text(text = text)
    }
}

@Composable
fun Paragraph(text: String){
    Text(modifier = Modifier.fillMaxWidth(), text = text, textAlign = TextAlign.Justify)
    Spacer(modifier = Modifier.size(10.dp))
}
@Composable
fun Subtitle(text: String){
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = text, fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.size(10.dp))
}

@Composable
fun Title(text: String){
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = text, fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.size(10.dp))
}