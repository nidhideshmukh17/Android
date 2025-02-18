package com.example.retrofit

import com.google.gson.annotations.SerializedName

data class APIResponse(
    @SerializedName("data")
    var user : User,
    var support : Support
)

data class User(
    var id : Int,
    var email : String,
    @SerializedName("first_name")
    var firstName : String,
    @SerializedName("last_name")
    var lastName : String,
    var avatar : String
)

data class Support(
    var url : String,
    var text : String
)