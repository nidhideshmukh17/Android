package com.example.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.widget.Toast

class MediaPlayerService : Service(){
    private lateinit var mediaPlayer : MediaPlayer
    private lateinit var uri : Uri

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, "onCreate method is called", Toast.LENGTH_LONG).show()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "onStartCommand -- $startId", Toast.LENGTH_LONG).show()
        if (intent!!.hasExtra("file_path")){
            uri = Uri.parse(intent.getStringExtra("file_path"))
        }
        mediaPlayer = MediaPlayer.create(this,uri)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        Toast.makeText(this, "onBind method is called", Toast.LENGTH_LONG).show()
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

//  file:///storage/emulated/0/Music/song.mp3