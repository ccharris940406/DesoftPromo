package com.desoft.promodesoft

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener

class Product : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val ret = inflater.inflate(R.layout.fragment_product, container, false)

        setFragmentResultListener("productKey"){
            requestKey, bundle ->
            val productChoosen = bundle.getString("productChoosen")
            data class duple (val productName:String, val producDescription:String)
            val printer:duple = when(productChoosen){
                "energux" ->                    duple(getString(R.string.energux), getString(R.string.energux_description))
                "cheqcon" ->                    duple(getString(R.string.cheqcon), getString(R.string.cheqcon_description))
                "agenda_express" ->             duple(getString(R.string.agenda_express), getString(R.string.agenda_description))
                "mentor" ->                     duple(getString(R.string.mentor), getString(R.string.mentor_description))
                "gestion_mantenimiento" ->      duple(getString(R.string.gestion_mantenimiento),getString(R.string.gestion_mantenimiento_description))
                "seguridad_inf" ->              duple(getString(R.string.seguridad_inf), getString(R.string.seguridad_inf_description))
                "versige" ->                    duple(getString(R.string.versige), getString(R.string.versige_description))
                "fastos" ->                     duple(getString(R.string.fastos), getString(R.string.fastos_description))
                "siscoh" ->                     duple(getString(R.string.siscoh), getString(R.string.siscoh_description))
                "acuerdos" ->                   duple(getString(R.string.acuerdos), getString(R.string.acuerdos_description))
                else ->                         duple(getString(R.string.versat), getString(R.string.versat_description))
                }

            val productNameTextView:TextView = ret.findViewById(R.id.product_name)
            val descriptionTextView:TextView =ret.findViewById(R.id.product_description)
            descriptionTextView.movementMethod = ScrollingMovementMethod()

            productNameTextView.text = printer.productName
            descriptionTextView.text = printer.producDescription
        }

        return ret
    }

}