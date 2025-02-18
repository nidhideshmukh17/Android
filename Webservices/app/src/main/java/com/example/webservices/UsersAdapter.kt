package com.example.webservices

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UsersAdapter(var users :ArrayList<User>): RecyclerView.Adapter<UsersAdapter.UsersViewHolder>(){
    inner class UsersViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var usersImageView : ImageView
        var txtViewForName : TextView
        var txtViewForEmail : TextView

        init {
            usersImageView = itemView.findViewById(R.id.userImageView)
            txtViewForName = itemView.findViewById(R.id.txtViewForName)
            txtViewForEmail = itemView.findViewById(R.id.txtViewForEmail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        var layoutInflater= LayoutInflater.from(parent.context)
        var userView = layoutInflater.inflate(R.layout.user_view_holder,null)
        return UsersViewHolder(userView)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        var userImageView = holder.itemView.findViewById<ImageView>(R.id.userImageView)
        var txtViewForName = holder.itemView.findViewById<TextView>(R.id.txtViewForName)
        var txtViewForEmail = holder.itemView.findViewById<TextView>(R.id.txtViewForEmail)
        txtViewForName.text = users[position].firstName + users[position].lastName
        txtViewForEmail.text = users[position].email

        Glide.with(holder.itemView)
            .load(users[position].avatar)
            .error(R.drawable.test_image_3)
            .placeholder(R.drawable.ic_launcher_background)
            .into(userImageView)
    }
}