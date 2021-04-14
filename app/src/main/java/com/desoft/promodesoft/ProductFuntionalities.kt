package com.desoft.promodesoft

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 * Use the [ProductFuntionalities.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductFuntionalities : Fragment() {

    private val model:productSelected by activityViewModels()
    private lateinit var productos:Array<String>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val ret = inflater.inflate(R.layout.fragment_product_funtionalities, container, false)
        productos = resources.getStringArray(R.array.products_array)
        val pname: TextView = ret.findViewById(R.id.product_name_funtionality)

        //setFragmentResultListener("functionalitiesKey"){
            //_, bundle ->
            //val productParent = bundle.getString("productParent")
            data class duple (val productName:String, val producFunctions:Array<String>)
            val printer:duple = when(model.selected){
                "agenda_express" ->             duple(getString(R.string.agenda_express), resources.getStringArray(R.array.agenda_func))
                "mentor" ->                     duple(getString(R.string.mentor), resources.getStringArray(R.array.mentor_func))
                "versige" ->                    duple(getString(R.string.versige), resources.getStringArray(R.array.vesige_func))
                "acuerdos" ->                   duple(getString(R.string.acuerdos), resources.getStringArray(R.array.acuerdos_func))
                "uforces" ->                    duple(getString(R.string.uforces), resources.getStringArray(R.array.uforces_func))
                else ->                  duple(getString(R.string.pc_inside), resources.getStringArray(R.array.pc_inside_func))
            }
            pname.text = printer.productName

            val recyclerView: RecyclerView = ret.findViewById(R.id.funtionalities_list)
            recyclerView.layoutManager = LinearLayoutManager(ret.context)
            recyclerView.adapter = FuntionalitiesListAdapter(printer.producFunctions)
        //}

        return ret
    }
}