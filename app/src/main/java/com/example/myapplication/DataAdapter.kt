package com.example.myapplication

import Attributes
import CovidDataItem
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.data_covid_item.*
import org.w3c.dom.Attr

class DataAdapter(private val context: Context, private val items: List<Attributes>, private val listener: (Attributes)->Unit) : RecyclerView.Adapter<DataAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(context, LayoutInflater.from(context).inflate(R.layout.data_covid_item, parent,false))


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position),listener)
    }

    class ViewHolder(val context: Context, override val containerView: View): RecyclerView.ViewHolder(containerView),LayoutContainer {
        fun bindItem(item: Attributes,listener: (Attributes) -> Unit){
            tv_korbanaktif.text = item.confirmed.toString()
            tv_korbanmeninggal.text = item.deaths.toString()
            tv_negara.text = item.countryRegion
            tv_korbansembuh.text = item.recovered.toString()

            containerView.setOnClickListener { listener(item) }
        }
    }
}