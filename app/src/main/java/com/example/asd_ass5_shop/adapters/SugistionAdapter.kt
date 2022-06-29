package com.example.asd_ass5_shop.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.asd_ass5_shop.Screens.ProductActivity
import com.example.asd_ass5_shop.classs.modle.productModle
import com.example.asd_ass5_shop.databinding.SuggistionDesginBinding
import com.squareup.picasso.Picasso

class SugistionAdapter(var context: Context, var array: ArrayList<productModle>) :
    RecyclerView.Adapter<SugistionAdapter.myViewHolder>() {

    class myViewHolder(var bindiing: SuggistionDesginBinding) :
        RecyclerView.ViewHolder(bindiing.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var binding = SuggistionDesginBinding.inflate(LayoutInflater.from(context), parent, false)

        return myViewHolder(binding)

    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        Picasso.get().load(array[position].image).into(holder.bindiing.imageView)
        holder.bindiing.title.text = array[position].name_en
        holder.bindiing.root.setOnClickListener {
            val i = Intent(context, ProductActivity::class.java)
            i.putExtra("prod", array[position])
            context.startActivity(i)

        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}