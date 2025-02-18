package com.example.webservices

import android.util.Log
import org.json.JSONObject
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class WebUtil {
    companion object WebUtil {
        fun getAllUsers(): ArrayList<User> {
            val url = URL("https://reqres.in/api/users?page=2")
            var httpsURLConnection = url.openConnection() as HttpsURLConnection
            httpsURLConnection.connect()

//        Log.e("tag", httpsURLConnection.url.toString())
//        Log.e("tag", httpsURLConnection.contentType)
//        Log.e("tag",httpsURLConnection.contentEncoding)
//        Log.e("tag", httpsURLConnection.requestMethod)
//        Log.e("tag",httpsURLConnection.responseMessage)

            var inputStream = httpsURLConnection.inputStream

            var buffer = StringBuffer()
            var byteArray = ByteArray(1024 * 1)
            var count = 0

            count = inputStream.read(byteArray)
            while (count != -1) {
                buffer.append(String(byteArray, 0, count))
                count = inputStream.read(byteArray)
            }

            inputStream.close()

            val responseObject = JSONObject(buffer.toString())

            val pageNumber = responseObject.getInt("page")
            val perPage = responseObject.getInt("per_page")
            val total = responseObject.getInt("total")
            val totalPages = responseObject.getInt("total_pages")

            val jsonArrayOfUsers = responseObject.getJSONArray("data")
            var users: ArrayList<User> = ArrayList<User>()

            for (i in 0..<jsonArrayOfUsers.length() - 1) {
                val eachUser = jsonArrayOfUsers.getJSONObject(i)
                Log.e("tag", "${eachUser.toString()}")
                val id = eachUser.getInt("id")
                val email = eachUser.getString("email")
                val firstName = eachUser.getString("first_name")
                val lastName = eachUser.getString("last_name")
                val imageURLString = eachUser.getString("avatar")

                users.add(User(id, email, firstName, lastName, imageURLString))
            }

            for (eachUser in users) {
                Log.e(
                    "tag",
                    "${eachUser.toString()} -- ${eachUser.id} -- ${eachUser.firstName} -- ${eachUser.email}"
                )
            }
            return users
        }
    }
}