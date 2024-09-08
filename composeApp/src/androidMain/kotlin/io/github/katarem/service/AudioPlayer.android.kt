package io.github.katarem.service

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.net.toUri
import commititnow.composeapp.generated.resources.Res
import io.github.katarem.utils.AppContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.compose.resources.ExperimentalResourceApi
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Files

actual class AudioPlayer {

    private var mediaPlayer: MediaPlayer? = null
    private val context: Context = AppContext.get()
    private var file: File? = null
    @RequiresApi(Build.VERSION_CODES.O)
    actual suspend fun playSound(resourcePath: String) {
        prepareFile(resourcePath).join()
        mediaPlayer = MediaPlayer().apply {
            this.isLooping = true
            this.setDataSource(context, file?.absolutePath?.toUri() ?: Uri.EMPTY)
            this.prepare()
            this.start()
        }

    }

    actual suspend fun stop(){
        mediaPlayer?.stop()
        file?.delete()
    }


    @OptIn(ExperimentalResourceApi::class)
    private suspend fun prepareFile(resourcePath: String) = coroutineScope {
        launch {
            val bytes = Res.readBytes(resourcePath)
            file = withContext(Dispatchers.IO){
                File.createTempFile("temp_audio",".bmp",context.cacheDir)
            }
            file?.outputStream().use { it?.write(bytes) }
        }

    }
}