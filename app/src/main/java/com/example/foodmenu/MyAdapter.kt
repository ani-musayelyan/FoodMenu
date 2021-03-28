package com.example.foodmenu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.google.android.material.snackbar.Snackbar


class MyAdapter(listArray: MutableList<ListItem> , context : Context ) : Adapter<MyAdapter.ViewHolder>() {
   var listArr = listArray
    var contextR = context
   // lateinit var favItem : ListItem


    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val titleText = view.findViewById<TextView>(R.id.titleText)
        val descText = view.findViewById<TextView>(R.id.descText)
        val image = view.findViewById<ImageView>(R.id.image)
        val rate = view.findViewById<TextView>(R.id.rate)

        var likeBtn = view.findViewById<Button>(R.id.likeBtn)
        fun bind(listItem : ListItem , context: Context) {
            titleText.text = listItem.title
            descText.text = listItem.desc
            rate.text = listItem.rate

            image.setImageResource(listItem.image)
            itemView.setOnClickListener{
                Snackbar.make(it , "${titleText.text}" , Snackbar.LENGTH_SHORT).show()
            }
            likeBtn.setOnClickListener {
                Toast.makeText(context , "Great choice!!!!Added to favourites" , Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout , parent , false))
    }

    override fun getItemCount(): Int {
        return listArr.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArr.get(position)
        holder.bind(listItem , contextR)
    }
}