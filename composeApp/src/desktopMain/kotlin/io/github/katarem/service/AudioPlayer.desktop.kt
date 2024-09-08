package io.github.katarem.service

import commititnow.composeapp.generated.resources.Res
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import org.jetbrains.compose.resources.ExperimentalResourceApi
import java.io.File
import javax.sound.sampled.AudioFormat
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.AudioSystem.getAudioInputStream
import javax.sound.sampled.Clip
import javax.sound.sampled.DataLine

actual class AudioPlayer {

    private var player: Clip? = null

    @OptIn(ExperimentalResourceApi::class)
    actual suspend fun playSound(resourcePath: String) = coroutineScope {
        if(player != null) return@coroutineScope // execute only once
        val file = prepareFile(resourcePath).await()
        val stream = getStream(file)
        player = AudioSystem.getClip()
        player?.open(stream)
        player?.loop(Clip.LOOP_CONTINUOUSLY)
        player?.start()
        return@coroutineScope
    }

    @OptIn(ExperimentalResourceApi::class)
    private suspend fun prepareFile(resourcePath: String): Deferred<File> = coroutineScope {
        return@coroutineScope async{
            val resource = Res.readBytes(resourcePath)
            val file = withContext(Dispatchers.IO) { File.createTempFile("sound", ".wav") }
            file.outputStream().use { it.write(resource) }
            return@async withContext(Dispatchers.IO) {
                return@withContext file
            }
        }
    }

    private fun getFormat(file: File): AudioFormat{
        return AudioSystem.getAudioFileFormat(file).format
    }
    private fun getStream(file: File): AudioInputStream{
        return getAudioInputStream(file)
    }

    actual suspend fun stop(){
        player?.stop()
        player?.close()
        player = null
    }

}