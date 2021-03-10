package com.desoft.promodesoft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 * Use the [Services.newInstance] factory method to
 * create an instance of this fragment.
 */
class Services : Fragment() {

    private lateinit var services:Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        services = resources.getStringArray(R.array.services_array)
        val ret = inflater.inflate(R.layout.fragment_services, container, false)
        val recyclerView: RecyclerView = ret.findViewById(R.id.services_list)
        recyclerView.layoutManager = LinearLayoutManager(ret.context)
        recyclerView.adapter = ServicesListAdapter(services)
        return ret
    }
}