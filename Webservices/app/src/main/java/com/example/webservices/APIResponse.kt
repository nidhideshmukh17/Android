package com.example.webservices

data class APIResponse(
    var page : Int,
    var perPage : Int,
    var total : Int,
    var totalPages:Int,
    var data : ArrayList<User>,
    var support : Support
)

data class User(
    var id :Int,
    var email: String,
    var firstName : String,
    var lastName : String,
    var avatar: String

)
data class Support(
    var url : String,
    var text: String
)
