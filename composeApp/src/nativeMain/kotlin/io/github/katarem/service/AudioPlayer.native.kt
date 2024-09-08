package io.github.katarem.service

actual class AudioPlayer {
    actual suspend fun playSound(resourcePath: String) {
        println("not implemented")
    }
    actual suspend fun stop(){
        println("not implemented")
    }
}