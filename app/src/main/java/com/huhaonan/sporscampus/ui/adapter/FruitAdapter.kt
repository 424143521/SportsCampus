package com.huhaonan.sporscampus.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
import com.huhaonan.sporscampus.ui.data.Fruit
import com.huhaonan.sportscampus.R

class FruitAdapter(val context: Context, val fruitList: List<Fruit>): RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val fruitImage = view.findViewById<ImageView>(R.id.userImage)
        val fruitName = view.findViewById<TextView>(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.school_item,parent,false)
        val holder = ViewHolder(view)
        holder.itemView.setOnClickListener {

        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitName.text = fruit.name
        holder.fruitImage.setImageResource(fruit.imageId)
        //加载图片
//        Glide.with(context).load(fruit.imageId).into(holder.fruitImage)
    }

    override fun getItemCount(): Int =fruitList.size
    }

