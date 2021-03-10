package com.desoft.promodesoft

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass.
 * Use the [Hold.newInstance] factory method to
 * create an instance of this fragment.
 */
class Hold : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val ret:View =  inflater.inflate(R.layout.fragment_hold, container, false)
        val productsButton: Button = ret.findViewById(R.id.productos_button)
        productsButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_hold_to_productos))
        val servicesButton: Button = ret.findViewById(R.id.services_button)
        servicesButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_hold_to_services))
        val contactUsButton: Button = ret.findViewById(R.id.contact_us_button)
        contactUsButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_hold_to_contactUs))
        return ret
    }
}