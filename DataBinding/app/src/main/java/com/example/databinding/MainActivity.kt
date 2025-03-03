package com.example.databinding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.databinding.databinding.ActivityMainBinding
import com.example.databinding.databinding.UserDetailsActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.btnNext.setOnClickListener{
            user = User(10, "Nidhi", "Nidhi@gmail.com","Amravati")

            var intent = Intent(this@MainActivity, UserDetailsActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }
}