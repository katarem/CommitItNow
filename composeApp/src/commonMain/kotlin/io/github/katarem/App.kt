package io.github.katarem

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview

import io.github.katarem.routing.Router

@Composable
@Preview
fun App() {
    MaterialTheme {
        Router()
    }
}