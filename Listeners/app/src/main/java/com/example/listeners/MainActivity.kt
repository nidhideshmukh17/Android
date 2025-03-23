package com.example.listeners

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var txtView1 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Method 1: Using setOnClickListener with Lambda Expression
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener{ view ->
            if(view == button1){
            }   //view can be rename by anything (for ex: nidhi,etc)
        }

        // Method 2: Using setOnClickListener with an Anonymous Class
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                if (view == button2)
                showToast("Button 2 clicked (Anonymous Class)")
            }
        })

        // Method 3: Using OnClickListener Interface Implementation
        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener(this)


        val button4 : Button = findViewById(R.id.button4)
        val ref : View.OnClickListener = MyBtnClickListener()
        button4.setOnClickListener(ref)

    }

    inner  class MyBtnClickListener : View.OnClickListener{
        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }
    }

    override fun onClick(v: View?) {

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
