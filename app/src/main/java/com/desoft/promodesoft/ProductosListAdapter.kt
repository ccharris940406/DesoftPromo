package com.desoft.promodesoft

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class ProductosListAdapter(private val dataSet: Array<String?>,
                           private val secondDataSet: Array<String>,
                           private val frag :Productos)
    : RecyclerView.Adapter<ProductosListAdapter.ViewHolder>() {

     class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
         val productButton: Button = view.findViewById(R.id.product_item_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.products_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productButton.text = dataSet[position]
        holder.productButton.setOnClickListener{view: View ->
            //frag.setFragmentResult("productKey", bundleOf("productChoosen" to secondDataSet[position]))
            frag.model.selected = secondDataSet[position]
            view.findNavController().navigate(R.id.action_productos_to_product)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}