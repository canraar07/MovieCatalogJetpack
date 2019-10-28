package com.canra.jetpackmovie.adapter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.canra.jetpackmovie.DetailActivity
import com.canra.jetpackmovie.R
import com.canra.jetpackmovie.util.DataItems
import kotlinx.android.synthetic.main.template_grid_menu.view.*

class AdapterMainActivity : RecyclerView.Adapter<AdapterMainActivity.GridViewHolder>() {

    private val list = ArrayList<DataItems>()


    fun setData(items: ArrayList<DataItems>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    fun dataClear() {
        list.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.template_grid_menu, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


    class GridViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: DataItems) {
            with(itemView){
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w780${data.img}")
                    .into(image_template)

                text_template.text = data.title
                itemView.setOnClickListener {
                    val bundle = Bundle()
                    bundle.putString("img",data.img)
                    bundle.putString("title",data.title)
                    bundle.putString("overview",data.overview)
                    bundle.putString("release_date",data.release_date)
                    bundle.putString("vote_average",data.vote_average)
                    val intent = Intent(context,DetailActivity::class.java)
                    intent.putExtras(bundle)
                    context.startActivity(intent)
                }
            }
        }
    }
}