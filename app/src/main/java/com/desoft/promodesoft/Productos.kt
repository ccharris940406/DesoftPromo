package com.desoft.promodesoft

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [Productos.newInstance] factory method to
 * create an instance of this fragment.
 */
class Productos : Fragment() {

    private lateinit var productos:Array<String>

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val ret:View = inflater.inflate(R.layout.fragment_productos, container, false)
        val linearLayout:LinearLayout = ret.findViewById(R.id.main_view)
        productos = resources.getStringArray(R.array.products_array)
        for (prod in productos){
            val but = Button(this.context)
            but.text = when(prod){
                "energux" -> getString(R.string.energux)
                "cheqcon" -> getString(R.string.cheqcon)
                "agenda_express" -> getString(R.string.agenda_express)
                "mentor" -> getString(R.string.mentor)
                "gestion_mantenimiento" -> getString(R.string.gestion_mantenimiento)
                "seguridad_inf" -> getString(R.string.seguridad_inf)
                "versige" -> getString(R.string.versige)
                "fastos" -> getString(R.string.fastos)
                "siscoh" -> getString(R.string.siscoh)
                else -> getString(R.string.versat)
            }
            //but.setBackgroundColor(ContextCompat.getColor(ret.context, R.color.company_secudary))
            val buttonColor = ContextCompat.getColor(ret.context, R.color.company_secudary)
            but.backgroundTintList = ColorStateList.valueOf(buttonColor)
            val params: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(0,0,0,16)
            but.setTextColor(Color.WHITE)
            but.setTextSize(2, 18.0f)
            but.setOnClickListener { view:View ->
                setFragmentResult("productKey", bundleOf("productChoosen" to prod))
                view.findNavController().navigate(R.id.action_productos_to_product)
            }
            linearLayout.addView(but, params)
        }
        return ret
    }
}