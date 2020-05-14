package com.example.pantaucorona

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.negara_api_item.*

class NegaraApiAdapter(private val context: Context, private val items:
List<NegaraApiItem>, private val listener: (NegaraApiItem)-> Unit) :
    RecyclerView.Adapter<NegaraApiAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(context, LayoutInflater.from(context).inflate(R.layout.negara_api_item,
            parent, false))
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)
    }
    class ViewHolder(val context: Context, override val containerView : View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item: NegaraApiItem, listener: (NegaraApiItem) -> Unit) {
            txtNegara.text = item.attributes.countryRegion
            txtPositif.text = item.attributes.confirmed.toString()
            txtSembuh.text = item.attributes.recovered.toString()
            txtMeninggal.text = item.attributes.deaths.toString()
            containerView.setOnClickListener { listener(item) }
        }
    }
}