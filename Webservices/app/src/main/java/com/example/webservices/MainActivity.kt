package com.example.webservices

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.StrictMode
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewForUsers: RecyclerView
    private var users = ArrayList<User>()
    private lateinit var usersAdapter : UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //        StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder().build());
        var policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        WebThread(MessageHandler()).execute()
        initRecyclerView()
    }
    private fun initRecyclerView(){
        recyclerViewForUsers = findViewById(R.id.recyclerViewForUsers)
        usersAdapter = UsersAdapter(users)
        recyclerViewForUsers.adapter = usersAdapter
        recyclerViewForUsers.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }
    inner class MessageHandler : Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            var usersResponse = msg.obj as ArrayList<User>

            //refer to users array from outer class i.e. MainActivity
            this@MainActivity.users.addAll(usersResponse)
            usersAdapter.notifyDataSetChanged()   //imp
        }
    }
}