package io.github.katarem.utils

import com.russhwolf.settings.Settings
import com.russhwolf.settings.set
import io.github.katarem.routing.Routes

object UserPreferences{
    private val settings = Settings()
    fun completeFirstLaunch(){
        settings["launched_before"] = true
    }
    fun getPreferedLimit(): String{
        return settings.getStringOrNull("prefered_limit") ?: "00:15:00"
    }
    fun isFirstLaunch(): Boolean{
        return settings.getBooleanOrNull("launched_before") == null
    }
}

object TimeParser{

    /**
     * Parses String value to an Instant
     * */
    fun parseTime(time: String): Long{
        val parts = time.split(":")
        val hours = parts[0].toLong()
        val minutes = parts[1].toLong()
        val seconds = parts[2].toLong()
        return (hours * 3600) + (minutes * 60) + seconds
    }

    fun parseToString(seconds: Long): String{
        val hours = (seconds / 3600)
            .toInt()
            .toString().padStart(2,'0')
        val minutes = ((seconds % 3600) / 60)
            .toInt()
            .toString().padStart(2,'0')
        val remainingSeconds = (seconds % 60)
            .toInt()
            .toString().padStart(2,'0')
        return "$hours:$minutes:$remainingSeconds"
    }
}

fun resolveFirstScreen(): String{
    return if(UserPreferences.isFirstLaunch()){
        UserPreferences.completeFirstLaunch()
        Routes.WELCOME_SCREEN.name
    } else
        Routes.MAIN_SCREEN.name
}