package com.desoft.promodesoft

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ServicesListAdapter(private val dataSet: Array<String>): RecyclerView.Adapter<ServicesListAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val servicesItemTextView: TextView = view.findViewById(R.id.services_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.services_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.servicesItemTextView.text = dataSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}