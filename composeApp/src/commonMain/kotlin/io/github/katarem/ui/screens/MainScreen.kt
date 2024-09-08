package io.github.katarem.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.katarem.states.MainScreenState
import io.github.katarem.utils.PRIMARY_COLOR
import io.github.katarem.viewmodel.MainScreenViewModel

@Composable
fun MainScreen(viewModel: MainScreenViewModel){

    val state = viewModel.state.collectAsState()
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {
                CircleCounter(state.value)
                TimeDisplay(viewModel)
        }
}

@Composable
fun CircleCounter(state: MainScreenState){
    //progreso real
    val progress = (state.timeCount.toFloat() / state.timeLimit.toFloat()).coerceIn(0f, 1f)
    // progreso animado
    val animatedProgress = animateFloatAsState(
        targetValue = progress, // El valor objetivo que queremos animar
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec // Usamos la animación predeterminada para indicadores de progreso
    )
        CircularProgressIndicator(
            progress = animatedProgress.value,
            modifier = Modifier.size(300.dp),
            strokeWidth = 35.dp,
            color = Color.Red
        )
}

@Composable
fun TimeDisplay(viewModel: MainScreenViewModel){
    val state = viewModel.state.collectAsState()

    val counterControlText = if(state.value.startCounter)
        "Pause" else "Start"

    Column(
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = state.value.displayTime,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold)
        Row(modifier = Modifier.padding(10.dp)){
            Button(
                onClick = viewModel::changeCoutingState,
                modifier = Modifier.padding(5.dp),
                colors = ButtonDefaults.textButtonColors(backgroundColor = PRIMARY_COLOR, contentColor = Color.White)){
                Text(counterControlText)
            }
            Button(
                onClick = viewModel::resetCounter,
                modifier = Modifier.padding(5.dp),
                colors = ButtonDefaults.textButtonColors(backgroundColor = PRIMARY_COLOR, contentColor = Color.White)){
                Text("Reset")
            }
        }
    }
}
