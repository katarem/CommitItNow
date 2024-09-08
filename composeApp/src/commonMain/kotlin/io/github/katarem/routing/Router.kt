package io.github.katarem.routing

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.katarem.ui.components.BottomBar
import io.github.katarem.ui.components.TopBar
import io.github.katarem.ui.screens.MainScreen
import io.github.katarem.ui.screens.WelcomeScreen
import io.github.katarem.utils.resolveFirstScreen
import io.github.katarem.viewmodel.MainScreenViewModel

@Composable
fun Router(){

    val navigator = rememberNavController()

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() }
    ){ paddingValues ->
        NavHost(navController = navigator,
            //startDestination = resolveFirstScreen(),
            startDestination = Routes.WELCOME_SCREEN.name,
            modifier = Modifier.padding(paddingValues)){
            composable(Routes.WELCOME_SCREEN.name){
                WelcomeScreen(navController = navigator)
            }
            composable(Routes.MAIN_SCREEN.name){
                MainScreen(
                    viewModel = viewModel{ MainScreenViewModel() }
                )
            }
        }
    }
}

enum class Routes {
    WELCOME_SCREEN,
    MAIN_SCREEN
}