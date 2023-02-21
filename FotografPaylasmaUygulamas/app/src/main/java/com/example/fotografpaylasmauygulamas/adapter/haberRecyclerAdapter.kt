package com.example.fotografpaylasmauygulamas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fotografpaylasmauygulamas.R
import com.example.fotografpaylasmauygulamas.model.Post
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_row.view.*

class haberRecyclerAdapter(val postList:ArrayList<Post>) :RecyclerView.Adapter<haberRecyclerAdapter.PostHolder>(){


    class PostHolder(itemView:View) :RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.recycler_row,parent,false)
        return PostHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.itemView.recycler_row_kullanici_email.text=postList[position].kullaniciEmail
        holder.itemView.recycler_row_yorum_text.text=postList[position].kullaniviYorum
        Picasso.get().load(postList[position].gorselUrl).into(holder.itemView.recycler_row_imageview)


    }
}