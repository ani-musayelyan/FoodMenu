package com.example.foodmenu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_food2.*
import kotlinx.android.synthetic.main.item_layout.*

class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food2)


        var list = mutableListOf<ListItem>()
        list.add(ListItem(R.mipmap.ic_brown_foreground , "Brownie" , "best brownie" , "4.5"))
        list.add(ListItem(R.mipmap.ic_cook_foreground , "Cookies" , "best cookies" , "3.8"))
        list.add(ListItem(R.mipmap.ic_chee_foreground , "Cheesecake" , "best cheesecake" , "4.2"))
        list.add(ListItem(R.mipmap.ic_machta_foreground , "Machta Cake" , "Try new cake" , "4.1"))
        list.add(ListItem(R.mipmap.ic_tiram_foreground, "Tiramisu" , "Italian Tiramisu cake" , "4.9"))
        list.add(ListItem(R.mipmap.ic_choco_foreground, "Chocolate cake" , "For chocoholics" , "5.0"))
        list.add(ListItem(R.mipmap.ic_straw_foreground, "Strawberry cake" , "Best strawberry cake" , "5.0"))


        content.hasFixedSize()
        content.layoutManager = LinearLayoutManager(this)
        content.adapter = MyAdapter(list , this)


        fab.setOnClickListener{
            val intentCall = Intent(Intent.ACTION_DIAL)
            intentCall.data = Uri.parse("tel:796-857-32-52")
            startActivity(intentCall)
        }

    }
}