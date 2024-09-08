package io.github.katarem.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.github.katarem.routing.Routes
import io.github.katarem.ui.components.MaterialTextButton
import io.github.katarem.ui.components.Paragraph
import io.github.katarem.ui.components.Subtitle
import io.github.katarem.ui.components.Title

@Composable
fun WelcomeScreen(navController: NavController?){
    Column(
        modifier = Modifier.fillMaxSize().padding(15.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Title("Bienvenido a Commit It Now!")
        Subtitle("¿Qué es Commit It Now?")
        Paragraph("Commit It Now es una app diseñada para programadores perezosos que continuan sus proyectos sin hacer un solo commit durante el proceso. Cuando tienes un error... zas! No hay versión anterior y se pierde mucho esfuerzo tiempo e incluso dinero por este problema.")
        Subtitle("Si ese es tu problema, sigue leyendo!")
        Paragraph("Pero si utilizas Commit It Now cada día, podemos aumentar tus commits al día, tanto tú como tus compañeros te lo agradecerán")
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
            MaterialTextButton(
                text = "Continuar",
                onClick = { navController?.navigate(Routes.MAIN_SCREEN.name) }
            )
        }
    }
}