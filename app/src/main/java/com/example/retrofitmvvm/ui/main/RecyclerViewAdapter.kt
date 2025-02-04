package com.example.retrofitmvvm.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmvvm.R
import com.example.retrofitmvvm.models.PostModel


class RecyclerViewAdapter()
    : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>()
{
    private var posts : List<PostModel> = ArrayList()
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

        var title : TextView = itemView.findViewById(R.id.titleTV)
        var userId : TextView = itemView.findViewById(R.id.userIDTV)
        var body : TextView = itemView.findViewById(R.id.bodyTV)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val  inflater = layoutInflater.inflate(R.layout.post_item, parent, false)
        return MyViewHolder(inflater)
    }

    fun setList(posts: List<PostModel>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = posts[position].title
        holder.userId.text = posts[position].userId.toString()
        holder.body.text = posts[position].body
    }

    override fun getItemCount(): Int {
        return posts.size
    }

}