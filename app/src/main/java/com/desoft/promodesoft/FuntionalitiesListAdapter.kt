package com.desoft.promodesoft

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FuntionalitiesListAdapter (private val dataSet: Array<String>):
    RecyclerView.Adapter<FuntionalitiesListAdapter.ViewHolder>()  {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val productFuncTextView: TextView = view.findViewById(R.id.funtionalities_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.funtionalities_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productFuncTextView.text = dataSet[position]
    }
}