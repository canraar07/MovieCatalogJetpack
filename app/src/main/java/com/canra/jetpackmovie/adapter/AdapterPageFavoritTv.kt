package com.canra.jetpackmovie.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.canra.jetpackmovie.DetailActivity
import com.canra.jetpackmovie.R
import com.canra.jetpackmovie.data.source.local.database.FavoritTv

class AdapterPageFavoritTv :
    PagedListAdapter<FavoritTv, AdapterPageFavoritTv.GridViewHolder>(
  DIFF_CALLBACK
) {
    companion object{
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<FavoritTv>(){
            override fun areContentsTheSame(oldItem: FavoritTv, newItem: FavoritTv): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areItemsTheSame(oldItem: FavoritTv, newItem: FavoritTv): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.template_grid_menu, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val data = getItem(position)
        holder.txtTitle.text = data?.title
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w780${data?.poster}")
            .into(holder.img)
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("id", data?.id.toString())
            bundle.putString("type", data?.type)
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtras(bundle)
            it.context.startActivity(intent)
        }
    }

    inner class GridViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView = itemView.findViewById(R.id.image_template)
        var txtTitle: TextView = itemView.findViewById(R.id.text_template)
    }
}