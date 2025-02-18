package com.example.retrofitapi

data class DataModel(
    var categories:ArrayList<String>,
    var created_at: String,
    var icon_url:String,
    var id:String,
    var updated_at:String,
    var url:String,
    var value:String
):java.io.Serializable
