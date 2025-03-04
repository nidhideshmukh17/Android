package com.example.services

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.services.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var intent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.btnStartService.setOnClickListener{
            intent = Intent(this@MainActivity, MediaPlayerService::class.java)
            intent.putExtra("file_path", activityMainBinding.edtText.text.toString())
            startService(intent)
        }
        activityMainBinding.btnStopService.setOnClickListener{
            stopService(intent)
        }
    }
}