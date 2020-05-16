package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.item.Article
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.news_item.*

class DataAdapter2 (

    private val context: Context,
    private val items: List<Article>,
    private val listener: (Article) -> Unit ) : RecyclerView.Adapter<DataAdapter2.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(context, LayoutInflater.from(context).inflate(R.layout.news_item, parent, false))

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class ViewHolder(val context: Context, override val containerView: View):
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bindItem(item : Article, listener: (Article) -> Unit){
            Glide.with(context).load(item.urlToImage).into(iv_berita)
            tv_judulBerita.text = item.title
            tv_tanggal.text = item.publishedAt
        }

    }


}