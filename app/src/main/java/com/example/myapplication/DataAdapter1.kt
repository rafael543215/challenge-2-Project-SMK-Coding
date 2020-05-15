package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.DataCountry
import com.example.myapplication.item.CovidConfirmedItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.data_covid_item.*

class DataAdapter1 (
    private val context : Context,
    private val items : List<CovidConfirmedItem>,
    private val listener: (CovidConfirmedItem) -> Unit
    ) : RecyclerView.Adapter<DataAdapter1.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        context,
        LayoutInflater.from(context).inflate(R.layout.data_covid_item, parent, false)
    )
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class ViewHolder(val context: Context, override val containerView: View): RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bindItem(item: CovidConfirmedItem, listener: (CovidConfirmedItem) -> Unit){
            tv_negara.text = item.countryRegion
            tv_korbansembuh.text = item.recovered.toString()
            tv_korbanmeninggal.text = item.deaths.toString()
            tv_korbanaktif.text = item.confirmed.toString()
        }
    }

}

