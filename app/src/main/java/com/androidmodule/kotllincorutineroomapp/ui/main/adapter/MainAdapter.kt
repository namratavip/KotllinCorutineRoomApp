package com.androidmodule.kotllincorutineroomapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidmodule.kotllincorutineroomapp.R
import com.androidmodule.kotllincorutineroomapp.data.local.entity.User
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(private val userList:ArrayList<User>) : RecyclerView.Adapter<MainAdapter.DataViewHolder>(){
    class DataViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindData(user:User){
            itemView.textViewUserName.text = user.name
            itemView.textViewUserEmail.text = user.email
            Glide.with(itemView.imageViewAvatar.context)
                .load(user.avatar)
                .into(itemView.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return userList.size;
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bindData(userList[position])
    }

    fun addDataToList(list :List<User>){
        userList.addAll(list)
    }


}