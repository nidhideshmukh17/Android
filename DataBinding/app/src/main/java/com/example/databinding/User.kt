package com.example.databinding

import java.io.Serializable

data class User(
    var userId : Int,
    var userName: String,
    var userEmail : String,
    var userCity : String,
) : Serializable
