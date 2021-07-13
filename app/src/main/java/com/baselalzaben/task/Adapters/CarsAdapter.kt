package com.baselalzaben.task.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.baselalzaben.task.Models.Cars
import com.baselalzaben.task.R
import com.squareup.picasso.Picasso

class CarsAdapter(private val carList: List<Cars>) :RecyclerView.Adapter<CarsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.car_item,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {

        return carList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Cars :${carList.size} ")


        return holder.bind(carList[position])

    }
    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {


        var imageView = itemView.findViewById<ImageView>(R.id.ivFlag)
        var tvbrand = itemView.findViewById<TextView>(R.id.tvTitle)
        var constractionYear = itemView.findViewById<TextView>(R.id.tvCases)
        var isUsed = itemView.findViewById<TextView>(R.id.isUsed)
        fun bind(car: Cars) {
            val name ="Cases :${car.isUsed.toString()}"
            tvbrand.text = car.brand
            constractionYear.text = name
            Picasso.get().load(car.imageUrl).into(imageView)
        }

    }



}