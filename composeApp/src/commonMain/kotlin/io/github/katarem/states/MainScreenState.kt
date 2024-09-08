package io.github.katarem.states

import io.github.katarem.utils.TimeParser
import io.github.katarem.utils.UserPreferences

data class MainScreenState(
    val timeCount: Long = 0L,
    val startCounter: Boolean = false,
    val timeLimit: Long = TimeParser.parseTime(UserPreferences.getPreferedLimit()),
    val displayTime: String = TimeParser.parseToString(timeLimit - timeCount),
)
