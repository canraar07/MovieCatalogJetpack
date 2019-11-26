package com.canra.jetpackmovie.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.canra.jetpackmovie.DetailActivity
import com.canra.jetpackmovie.R
import com.canra.jetpackmovie.util.DataFavorit
import kotlinx.android.synthetic.main.template_grid_menu.view.*

class AdapterListFavorit: RecyclerView.Adapter<AdapterListFavorit.GridViewHolder>() {

    private val list = ArrayList<DataFavorit>()
    private var typeFavorit : String = "movie"


    fun setDataFavorit(items: ArrayList<DataFavorit>, type: String) {
        list.clear()
        typeFavorit = type
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
        holder.bind(list[position],typeFavorit)
    }

    override fun getItemCount(): Int = list.size


    class GridViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: DataFavorit,type : String) {
            with(itemView) {
                if (data.type == type) {
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w780${data.img}")
                    .into(image_template)

                text_template.text = data.title
                itemView.setOnClickListener {
                    val bundle = Bundle()
                    bundle.putString("id", data.id)
                    bundle.putString("type", data.type)
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtras(bundle)
                    context.startActivity(intent)
                }
              }
            }
        }
    }
}