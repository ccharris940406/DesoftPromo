package com.desoft.promodesoft

import android.annotation.SuppressLint


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Productos : Fragment() {

    private lateinit var productos:Array<String>
    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val ret = inflater.inflate(R.layout.fragment_productos, container, false)
        productos = resources.getStringArray(R.array.products_array)
        val dataSet = arrayOfNulls<String>(productos.size)

        for ((index, prod) in productos.withIndex()){
            dataSet[index] = when(prod){
                "energux" -> getString(R.string.energux)
                "cheqcon" -> getString(R.string.cheqcon)
                "agenda_express" -> getString(R.string.agenda_express)
                "mentor" -> getString(R.string.mentor)
                "gestion_mantenimiento" -> getString(R.string.gestion_mantenimiento)
                "seguridad_inf" -> getString(R.string.seguridad_inf)
                "versige" -> getString(R.string.versige)
                "fastos" -> getString(R.string.fastos)
                "siscoh" -> getString(R.string.siscoh)
                "acuerdos" -> getString(R.string.acuerdos)
                else -> getString(R.string.versat)
            }

            val recyclerView: RecyclerView = ret.findViewById(R.id.productos_list)
            recyclerView.layoutManager = LinearLayoutManager(ret.context)
            recyclerView.adapter = ProductosListAdapter(dataSet, productos,this)
            }
        return ret
    }
}