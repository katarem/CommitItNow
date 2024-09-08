package io.github.katarem.service


expect class AudioPlayer() {
    suspend fun playSound(resourcePath: String)
    suspend fun stop()
}