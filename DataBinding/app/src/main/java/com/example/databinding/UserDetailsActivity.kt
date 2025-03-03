package com.example.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.databinding.databinding.UserDetailsActivityBinding

class UserDetailsActivity : AppCompatActivity() {
    private lateinit var userDetailsActivityBinding: UserDetailsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userDetailsActivityBinding = UserDetailsActivityBinding.inflate(layoutInflater)
        setContentView(userDetailsActivityBinding.root)
        var i = intent
        var user = i.getSerializableExtra("user") as User
        userDetailsActivityBinding.userObject = user
    }

}