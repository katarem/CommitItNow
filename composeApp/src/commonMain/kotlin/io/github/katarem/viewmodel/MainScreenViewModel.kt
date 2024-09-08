package io.github.katarem.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import commititnow.composeapp.generated.resources.Res
import io.github.katarem.service.AudioPlayer
import io.github.katarem.states.MainScreenState
import io.github.katarem.utils.QUACK_SOUND
import io.github.katarem.utils.TimeParser
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi

class MainScreenViewModel : ViewModel(){

    private var _state = MutableStateFlow(MainScreenState(timeLimit = TimeParser.parseTime("00:00:15")))
    val state = _state.asStateFlow()

    private val audioPlayer = AudioPlayer()

    private fun startQuack(){
        viewModelScope.launch {
           audioPlayer.playSound(QUACK_SOUND)
        }
    }

    private fun stopQuack(){
        viewModelScope.launch {
            audioPlayer.stop()
        }
    }

    fun changeCoutingState(){
        _state.update { it.copy(startCounter = !it.startCounter) }
        if(_state.value.startCounter)
            startCounting()
    }

    private fun startCounting(){
        viewModelScope.launch {
            while (_state.value.startCounter && notFinished()){
                val newTime = _state.value.timeCount + 1L
                val timeDiff = _state.value.timeLimit - newTime
                _state.update {
                    it.copy(
                        timeCount = newTime,
                        displayTime = TimeParser.parseToString(timeDiff)
                    )
                }
                delay(1000L)
            }
            _state.update { it.copy(startCounter = false) }
            startQuack()
        }
    }

    fun resetCounter(){
        viewModelScope.launch {
            _state.update {
                it.copy(
                    timeCount = 0,
                    displayTime = TimeParser.parseToString(it.timeLimit),
                    startCounter = false
                )
            }
        }
        stopQuack()
    }

    private fun notFinished(): Boolean{
        return _state.value.timeCount < _state.value.timeLimit
    }

}