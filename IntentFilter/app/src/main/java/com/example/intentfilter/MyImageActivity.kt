package com.example.intentfilter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intentfilter.databinding.MyImageActivityBinding

class MyImageActivity : AppCompatActivity() {
    private lateinit var myImageActivityBinding: MyImageActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myImageActivityBinding = MyImageActivityBinding.inflate(layoutInflater)
        setContentView(myImageActivityBinding.root)
    }
}